package org.example.ui.pages.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMainPage {
    private final By geoPositionLinkBy = By.cssSelector(".link_geosuggest_yes");
    private final By moreMenuButtonBy = By.cssSelector("div.services-new__more-icons");
    private final By moreMenuContentBy = By.cssSelector("div.services-new__more-popup-content a");

    private final WebDriver driver;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GeoPositionPage clickGeoPositionLink() {
        driver.findElement(geoPositionLinkBy).click();
        return new GeoPositionPage(driver);
    }

    public void clickMoreMenuButton() {
        driver.findElement(moreMenuButtonBy).click();
    }

    public List<String> getMoreMenuContent() {
        return driver.findElements(moreMenuContentBy).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
