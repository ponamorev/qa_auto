package org.example.ui.pages;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.example.ui.LogToAllure.logDebug;
import static org.example.ui.LogToAllure.logError;
import static org.example.ui.LogToAllure.logWarn;

@Slf4j
public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToBeLoaded() {
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            log.debug("Can't load page for 10 seconds.. Try again");
            logDebug("Can't load page for 10 seconds.. Try again");
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected WebElement getClickableElement(By element) {
        return getElement(element, true);
    }

    protected WebElement getElement(By element) {
        return getElement(element, false);
    }

    protected void clickProbablyStaleElement(By element) {
        try {
            getClickableElement(element).click();
        } catch (StaleElementReferenceException e) {
            log.warn("Element {} is absent in DOM, try to find it again..", element);
            logWarn("Element {} is absent in DOM, try to find it again..", element);
            waitForPageToBeLoaded();
            getClickableElement(element).click();
        }
    }

    private WebElement getElement(By element, boolean isClickable) {
        WebElement foundElement = null;
        try {
            foundElement = driver.findElement(element);
            log.debug("Found element [{}]", element);
            logDebug("Found element [{}]", element);
        } catch (NoSuchElementException e) {
            log.warn("Can't find element [{}] by implicit wait.. Start explicit wait", element);
            logWarn("Can't find element [{}] by implicit wait.. Start explicit wait", element);
        }
        if (Objects.nonNull(foundElement)) {
            return foundElement;
        }
        try {
            foundElement = isClickable
                    ? new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
                    : new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
            log.debug("Found element [{}] after explicit wait", element);
            logDebug("Found element [{}] after explicit wait", element);
        } catch (TimeoutException e) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            log.error("Element [{}] wasn't found by implicit and explicit wait. Check the selector is correct", element);
            logError("Element [{}] wasn't found by implicit and explicit wait. Check the selector is correct", element);
            Assertions.fail(String.format("Element [%s] wasn't found by implicit and explicit wait. Check the selector is correct", element));
        }
        return foundElement;
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    protected byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
