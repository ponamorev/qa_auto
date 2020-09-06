package org.example.ui.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GeoPositionPage extends BasePage {
    @FindBy(id = "city__front-input")
    private WebElement cityInput;
    @FindBy(css = ".popup__items li")
    private List<WebElement> popupCitiesList;

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
        popupCitiesList.get(0).click();
        return new YandexMainPage(driver);
    }
}
