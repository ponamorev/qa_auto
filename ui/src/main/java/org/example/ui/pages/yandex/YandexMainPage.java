package org.example.ui.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMainPage {
    @FindBy(css = ".link_geosuggest_yes")
    private WebElement geoPositionLink;
    @FindBy(css = "div.services-new__more-icons")
    private WebElement moreMenuButton;
    @FindBy(css = "div.services-new__more-popup-content a")
    private List<WebElement> moreMenuContent;

    private final WebDriver driver;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GeoPositionPage clickGeoPositionLink() {
        geoPositionLink.clear();
        return new GeoPositionPage(driver);
    }

    public void clickMoreMenuButton() {
        moreMenuButton.click();
    }

    public List<String> getMoreMenuContent() {
        return moreMenuContent.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
