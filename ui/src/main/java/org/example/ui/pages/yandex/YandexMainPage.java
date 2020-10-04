package org.example.ui.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMainPage extends BasePage {
    @FindBy(css = ".link_geosuggest_yes")
    private WebElement geoLink;
    @FindBy(css = "div.services-new__more-icons")
    private WebElement menuMoreButton;
    @FindBy(css = "div.services-new__more-popup-content a")
    private List<WebElement> menuMoreContent;

    public YandexMainPage(WebDriver driver) {
        super(driver);
        init(this);
    }

    public GeoPositionPage clickGeoPositionLink() {
        geoLink.click();
        return new GeoPositionPage(driver);
    }

    public String getGeoPosition() {
        return geoLink.getText();
    }

    public void clickMoreMenuButton() {
        menuMoreButton.click();
    }

    public List<String> getMoreMenuContent() {
        return menuMoreContent.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
