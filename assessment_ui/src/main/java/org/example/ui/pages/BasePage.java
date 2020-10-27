package org.example.ui.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, 5);
        pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Step(value = "Получить clickable WebElement")
    protected WebElement getClickableElement(By element) {
        return getElement(element, true);
    }

    @Step(value = "Получить WebElement")
    protected WebElement getElement(By element) {
        return getElement(element, false);
    }

    private WebElement getElement(By element, boolean isClickable) {
        WebElement foundElement = null;
        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        try {
            foundElement = driver.findElement(element);
        } catch (NoSuchElementException e) {
            log.warn("Can't find element [{}] by implicit wait.. Start explicit wait", element);
        }
        if (Objects.nonNull(foundElement)) {
            return foundElement;
        }
        try {
            foundElement = isClickable
                    ? new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element))
                    : new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(element));
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
