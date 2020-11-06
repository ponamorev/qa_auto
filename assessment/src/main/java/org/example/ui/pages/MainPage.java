package org.example.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector(".button.desk-notif-card__login-enter-expanded");
    private final By videoButton = By.xpath("//*[@data-id='video']");
    private final By imagesButton = By.xpath("//*[@data-id='images']");
    private final By newsButton = By.xpath("//*[@data-id='news']");
    private final By mapsButton = By.xpath("//*[@data-id='maps']");
    private final By marketButton = By.xpath("//*[@data-id='market']");
    private final By translateButton = By.xpath("//*[@data-id='translate']");
    private final By musicButton = By.xpath("//*[@data-id='music']");
    private final By settingsDropDownMenuButton = By.xpath("//a[@role='button']/parent::div[contains(@class, 'dropdown2')]");
    private final By portalSettingsButton = By.xpath("//a[@data-statlog='head.settings.other']");

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

    public void clickSettingsDropDownMenuButton() {
        try {
            getClickableElement(settingsDropDownMenuButton).click();
        } catch (ElementNotInteractableException e) {
            log.warn("Can't find element {} on the screen, search element after scroll down the screen..", settingsDropDownMenuButton);
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
}
