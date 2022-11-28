package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    private final By searchInput = By.id("text");
    private final By searchButton = By.className("search3__button");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void checkSearchInputIsVisible() {
        ensureElementIsVisible(searchInput);
    }

    public void checkSearchInputIsClickable() {
        ensureElementIsClickable(searchInput);
    }

    public void clearSearchInput() {
        driver.findElement(searchInput).clear();
    }

    public void clickSearchInput() {
        driver.findElement(searchInput).click();
    }

    public void sendKeysToSearchInput(String keys) {
        driver.findElement(searchInput).sendKeys(keys);
    }

    public void checkSearchButtonIsVisible() {
        ensureElementIsVisible(searchButton);
    }

    public void checkSearchButtonIsClickable() {
        ensureElementIsClickable(searchButton);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
