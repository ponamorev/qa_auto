package org.example.ui.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMainPage {
    @FindBy(css = ".link_geosuggest_yes")
    private WebElement geoPositionLink;

    private WebDriver driver;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }
}
