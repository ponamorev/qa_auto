package org.example.ui.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GeoPositionPage {
    @FindBy(id = "city__front-input")
    private WebElement cityInput;
    @FindBy(css = ".popup__items li")
    private List<WebElement> citiesPopup;

    private WebDriver driver;

    public GeoPositionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearCityInput() {
        cityInput.clear();
    }

    public void setCityToInputLine(String city) {
        cityInput.sendKeys(city);
    }

    public YandexMainPage chooseCityFromPopup() {
        citiesPopup.get(0).click();
        return new YandexMainPage(driver);
    }
}
