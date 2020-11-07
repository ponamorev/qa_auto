package org.example.ui.pages.kinopoisk;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KinopoiskMainPage extends BasePage {
    private final By searchInput = By.xpath("//input");
    private final By suggestedSearchOptions = By.cssSelector(".kinopoisk-header-suggest-item");

    public KinopoiskMainPage(WebDriver driver) {
        super(driver);
    }

    public void clearSearchInput() {
        getClickableElement(searchInput).clear();
    }

    public void clickSearchInput() {
        getClickableElement(searchInput).click();
    }

    public void sendTextToSearchInput(String text) {
        getClickableElement(searchInput).sendKeys(text);
    }

    public void clickSuggestedSearchOption(int index) {
        driver.findElements(suggestedSearchOptions).get(index - 1).click();
    }
}
