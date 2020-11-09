package org.example.ui.pages.maps;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapsPage extends BasePage {
    private final By actualButton = By.xpath("//div[@class='map-controls__additional-button']/button");
    private final By covidMapsLink = By.xpath("//a[@class='actual-panel-view__link']");

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    public void clickActualButton() {
        getClickableElement(actualButton).click();
    }

    public void clickCovidMapsLink() {
        getClickableElement(covidMapsLink).click();
    }
}
