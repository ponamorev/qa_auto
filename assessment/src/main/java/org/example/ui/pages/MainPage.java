package org.example.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.math.BigDecimal;

@Slf4j
public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector(".button.desk-notif-card__login-enter-expanded");
    private final By videoButton = By.xpath("//a[@data-id='video']");
    private final By imagesButton = By.xpath("//a[@data-id='images']");
    private final By newsButton = By.xpath("//a[@data-id='news']");
    private final By mapsButton = By.xpath("//a[@data-id='maps']");
    private final By marketButton = By.xpath("//a[@data-id='market']");
    private final By translateButton = By.xpath("//a[@data-id='translate']");
    private final By musicButton = By.xpath("//a[@data-id='music']");
    private final By moreMenuButton = By.xpath("//a[@data-id='more']");
    private final By kinopoiskButton = By.xpath("//a[@data-id='kinopoisk_old']");
    private final By settingsDropDownMenuButton = By.xpath("//a[@role='button']/parent::div[contains(@class, 'dropdown2')]");
    private final By portalSettingsButton = By.xpath("//a[@data-statlog='head.settings.other']");
    private final By moreStocksButton = By.xpath("//span[@data-statlog='news_rates_manual.more']");
    private final By dollarCurrencyStocksRate = By.xpath("//tr[@class='inline-stocks__row_id_1']//i[@class='inline-stocks__cell']");
    private final By searchInput = By.id("text");
    private final By submitSearchButton = By.xpath("//button[@type='submit']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        getClickableElement(loginButton).click();
    }

    public void clickVideoButton() {
        getClickableElement(videoButton).click();
    }

    public void clickImagesButton() {
        getClickableElement(imagesButton).click();
    }

    public void clickNewsButton() {
        getClickableElement(newsButton).click();
    }

    public void clickMapsButton() {
        getClickableElement(mapsButton).click();
    }

    public void clickMarketButton() {
        getClickableElement(marketButton).click();
    }

    public void clickTranslateButton() {
        getClickableElement(translateButton).click();
    }

    public void clickMusicButton() {
        getClickableElement(musicButton).click();
    }

    public void clickMoreMenuButton() {
        getClickableElement(moreMenuButton).click();
    }

    public void clickKinopoiskButton() {
        getClickableElement(kinopoiskButton).click();
    }

    public void clickSettingsDropDownMenuButton() {
        try {
            getClickableElement(settingsDropDownMenuButton).click();
        } catch (ElementNotInteractableException e) {
            log.warn("Can't find element {} on the screen, search element after scroll down the screen..", settingsDropDownMenuButton);
            LogToAllure.logWarn("Can't find element {} on the screen, search element after scroll down the screen..", settingsDropDownMenuButton);
            new Actions(driver)
                    .moveToElement(getClickableElement(settingsDropDownMenuButton))
                    .build()
                    .perform();
            getClickableElement(settingsDropDownMenuButton).click();
        }
    }

    public void clickPortalSettingsButton() {
        getClickableElement(portalSettingsButton).click();
    }

    public void clickMoreStocksButton() {
        getClickableElement(moreStocksButton).click();
    }

    public BigDecimal getDollarCurrencyRate() {
        String dollarRate = getElement(dollarCurrencyStocksRate).getText();
        dollarRate = dollarRate.replace(",", ".");
        try {
            return new BigDecimal(dollarRate);
        } catch (NumberFormatException e) {
            log.error("Проблема с приведением строки {} к BigDecimal", dollarRate);
            LogToAllure.logError("Проблема с приведением строки {} к BigDecimal", dollarRate);
            Assertions.fail(String.format("Проблема с приведением строки %s к BigDecimal", dollarRate));
            return BigDecimal.ZERO;
        }
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

    public void clickSubmitSearchButton() {
        getClickableElement(submitSearchButton).click();
    }
}
