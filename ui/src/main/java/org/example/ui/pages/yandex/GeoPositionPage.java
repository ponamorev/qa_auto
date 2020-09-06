package org.example.ui.pages.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeoPositionPage {
    private final By cityInputBy = By.id("city__front-input");
    private final By citiesListPopupBy = By.cssSelector(".popup__items li");

    private final WebDriver driver;

    public GeoPositionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearCityInput() {
        driver.findElement(cityInputBy).clear();
    }

    public void setCityToInputLine(String city) {
        driver.findElement(cityInputBy).sendKeys(city);
    }

    public YandexMainPage chooseCityFromPopup() {
        driver.findElements(citiesListPopupBy).get(0).click();
        return new YandexMainPage(driver);
    }
}
