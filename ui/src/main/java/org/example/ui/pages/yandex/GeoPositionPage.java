package org.example.ui.pages.yandex;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeoPositionPage extends BasePage {
    @FindBy(id = "city__front-input")
    private WebElement cityInput;
    @FindBy(css = ".popup__items li:first-child")
    private WebElement popupFirstCity;

    public GeoPositionPage(WebDriver driver) {
        super(driver);
        init(this);
    }

    public void clearCityInput() {
        cityInput.clear();
    }

    public void setCityToInputLine(String city) {
        cityInput.sendKeys(city);
    }

    public YandexMainPage chooseCityFromPopup() {
        try {
            cityInput.click();
            popupFirstCity.click();
        } catch (StaleElementReferenceException e) {
            init(this);
            cityInput.click();
            popupFirstCity.click();
        }
        return new YandexMainPage(driver);
    }
}
