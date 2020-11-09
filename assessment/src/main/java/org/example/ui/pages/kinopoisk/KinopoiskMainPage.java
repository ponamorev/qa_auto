package org.example.ui.pages.kinopoisk;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KinopoiskMainPage extends BasePage {
    private final By searchInput = By.xpath("//input");
    private final By suggestedSearchOptions = By.cssSelector(".kinopoisk-header-suggest-item");
    private final By filmListLink = By.xpath("(//a[text()='Списки фильмов'])[2]");
    private final By menuButton = By.xpath("//button[@data-tid='c1df441f']");
    private final By filmListMenuLink = By.xpath("(//a[text()='Списки фильмов'])[1]");
    private final By advancedSearchSettingsButton = By.className("_1dp226jcDt_jum2k1IGKC_");

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

    public void clickDirectFilmListLink() {
        getClickableElement(filmListLink).click();
    }

    public void clickMenuFilmListLink() {
        getClickableElement(filmListMenuLink).click();
    }

    public void clickMenuButton() {
        getClickableElement(menuButton).click();
    }

    public void clickAdvancedSearchSettingsButton() {
        getClickableElement(advancedSearchSettingsButton).click();
    }
}
