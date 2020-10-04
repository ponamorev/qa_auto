package org.example.ui.pages.yandex;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;

    protected void waitForPageToBeLoaded() {
        WebDriverWait pageLoadWaiter = new WebDriverWait(driver, 5);
        pageLoadWaiter.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        waitForPageToBeLoaded();
    }

    protected void init(BasePage page) {
        PageFactory.initElements(driver, page);
    }
}
