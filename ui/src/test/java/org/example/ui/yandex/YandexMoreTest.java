package org.example.ui.yandex;

import org.example.ui.drivers.Driver;
import org.example.ui.pages.yandex.GeoPositionPage;
import org.example.ui.pages.yandex.YandexMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMoreTest {
    private final WebDriver driver = Driver.getDriver();

    @BeforeEach
    public void setUp() {
        String url = "https://yandex.ru";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void moreMenuContentComparisonTest() {
        YandexMainPage mainPage = new YandexMainPage(driver);
        GeoPositionPage geoPositionPage = mainPage.clickGeoPositionLink();
        geoPositionPage.clearCityInput();
        geoPositionPage.setCityToInputLine("Лондон");
        mainPage = geoPositionPage.chooseCityFromPopup();
        mainPage.clickMoreMenuButton();
        List<String> londonMoreMenuContent = mainPage.getMoreMenuContent();

        geoPositionPage = mainPage.clickGeoPositionLink();
        geoPositionPage.clearCityInput();
        geoPositionPage.setCityToInputLine("Париж");
        mainPage = geoPositionPage.chooseCityFromPopup();
        mainPage.clickMoreMenuButton();
        List<String> parisMoreMenuContent = mainPage.getMoreMenuContent();

        Assertions.assertLinesMatch(londonMoreMenuContent, parisMoreMenuContent,
                "Содержимое меню \"ещё\" не совпадает для городов Лондон и Париж");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
