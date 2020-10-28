package org.example.ui.pages;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

@Slf4j
public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToBeLoaded() {
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, 10);
        try {
            pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("eager"));
        } catch (TimeoutException e) {
            log.debug("Can't load page for 10 seconds.. Try again");
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("eager"));
        }
    }

    protected WebElement getClickableElement(By element) {
        return getElement(element, true);
    }

    protected WebElement getElement(By element) {
        return getElement(element, false);
    }

    private WebElement getElement(By element, boolean isClickable) {
        WebElement foundElement = null;
        try {
            foundElement = driver.findElement(element);
            log.debug("Found element [{}]", element);
        } catch (NoSuchElementException e) {
            log.warn("Can't find element [{}] by implicit wait.. Start explicit wait", element);
        }
        if (Objects.nonNull(foundElement)) {
            return foundElement;
        }
        try {
            foundElement = isClickable
                    ? new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element))
                    : new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(element));
            log.debug("Found element [{}] after explicit wait", element);
        } catch (TimeoutException e) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            log.error("Element [{}] wasn't found by implicit and explicit wait. Check the selector is correct", element);
            Assertions.fail(String.format("Element [%s] wasn't found by implicit and explicit wait. Check the selector is correct", element));
        }
        return foundElement;
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    private byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
