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
abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        waitForPageToBeLoaded();
    }

    protected void waitForPageToBeLoaded() {
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, 5);
        pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Step(value = "Получить WebElement")
    protected WebElement getElement(By element, boolean isClickable) {
        WebElement foundElement = null;
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
