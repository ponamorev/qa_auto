package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private final int defaultTimeout = 10;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToBeLoaded() {
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        try {
            pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            System.err.println("Can't load the page");
        }
    }

    protected void ensureElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Can't find an element by locator " + locator.toString());
        }
    }

    protected void ensureElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.err.println("Element " + locator.toString() + " is not clickable yet");
        }
    }

    protected void ensureThereIsAtLeastOneElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        try {
            wait.until(dr -> dr.findElements(locator).size() > 0);
        } catch (TimeoutException e) {
            System.err.println("There is no one element found by locator " + locator.toString());
        }
    }
}
