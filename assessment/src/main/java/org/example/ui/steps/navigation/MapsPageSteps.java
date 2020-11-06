package org.example.ui.steps.navigation;

import io.qameta.allure.Step;
import org.example.ui.pages.navigation.MapsPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MapsPageSteps extends BaseSteps {
    private final MapsPage page;

    public MapsPageSteps(WebDriver driver) {
        page = new MapsPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Карты")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step(value = "Проверить, что страница с Яндекс.Карты была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Карты — поиск мест и адресов, городской транспорт";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Карты не совпадает с ожидаемым");
    }
}
