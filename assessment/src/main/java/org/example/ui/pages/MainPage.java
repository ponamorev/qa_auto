package org.example.ui.pages;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.math.BigDecimal;

@Slf4j
public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector(".desk-notif-card__login-new-item.desk-notif-card__login-new-item_enter");
    private final By videoButton = By.xpath("//a[@data-id='video']");
    private final By imagesButton = By.xpath("//a[@data-id='images']");
    private final By newsButton = By.xpath("//a[@data-id='news']");
    private final By mapsButton = By.xpath("//a[@data-id='maps']");
    private final By marketButton = By.xpath("//a[@data-id='market']");
    private final By translateButton = By.xpath("//a[@data-id='translate']");
    private final By musicButton = By.xpath("//a[@data-id='music']");
    private final By moreMenuButton = By.xpath("//a[@data-id='more']");
    private final By kinopoiskButton = By.xpath("//a[@data-id='kinopoisk_old']");
    private final By settingsDropDownMenuButton = By.xpath("//a[@data-statlog='foot.settings']");
    private final By portalSettingsButton = By.xpath("//a[@data-statlog='head.settings.other']");
    private final By dollarCurrencyStocksRate = By.xpath("(//div[contains(text(),'USD')])[1]/../following-sibling::div[@class='stocks-new__item-right']/div[@class='stocks-new__item-value']");
    private final By searchInput = By.id("text");
    private final By submitSearchButton = By.xpath("//button[@type='submit']");
    private final By authorizedMailButton = By.xpath("//*[@class='desk-notif-card__mail-title']");
    private final By accountButton = By.cssSelector(".home-link.usermenu-link__control");
    private final By userName = By.xpath("//*[@class='usermenu__user-name']");
    private final By logoutButton = By.xpath("//span[text()='Выйти']/..");

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
            new Actions(driver)
                    .moveToElement(getClickableElement(settingsDropDownMenuButton))
                    .build()
                    .perform();
            getClickableElement(settingsDropDownMenuButton).click();
        } catch (ElementClickInterceptedException e) {
            log.warn("Click settings button was intercepted, try to do it again");
            LogToAllure.logWarn("Click settings button was intercepted, try to do it again");
            getClickableElement(settingsDropDownMenuButton).click();
        } catch (ElementNotInteractableException e) {
            log.warn("Click settings button is disable because of element is not interactable, try to find it again");
            LogToAllure.logWarn("Click settings button is disable because of element is not interactable, try to find it again");
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

    public BigDecimal getDollarCurrencyRate() {
        String dollarRate = getElement(dollarCurrencyStocksRate).getText();
        dollarRate = dollarRate.replace(",", ".").substring(0, dollarRate.length() - 2);
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

    public void clickAuthorizedMailButton() {
        getClickableElement(authorizedMailButton).click();
    }

    public void clickAccountButton() {
        getClickableElement(accountButton).click();
    }

    public String getUserName() {
        return getElement(userName).getText();
    }

    public void clickLogoutButton() {
        getClickableElement(logoutButton).click();
    }

    public boolean isLoginButtonDisplayed() {
        return getClickableElement(loginButton).isDisplayed();
    }
}
