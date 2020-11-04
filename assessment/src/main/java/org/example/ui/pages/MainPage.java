package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector(".button.desk-notif-card__login-enter-expanded");
    private final By videoButton = By.xpath("//*[@data-id=\"video\"]");
    private final By imagesButton = By.xpath("//*[@data-id=\"images\"]");
    private final By newsButton = By.xpath("//*[@data-id=\"news\"]");
    private final By mapsButton = By.xpath("//*[@data-id=\"maps\"]");
    private final By marketButton = By.xpath("//*[@data-id=\"market\"]");
    private final By translateButton = By.xpath("//*[@data-id=\"translate\"]");
    private final By musicButton = By.xpath("//*[@data-id=\"music\"]");

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
}
