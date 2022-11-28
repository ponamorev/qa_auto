package org.example.ui.steps.maps;

import io.qameta.allure.Step;
import org.example.ui.pages.maps.MapsPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MapsPageSteps extends BaseSteps {
    private final MapsPage page;

    public MapsPageSteps(WebDriver driver) {
        page = new MapsPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Карты")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Карты была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "Яндекс.Карты — транспорт, навигация, поиск мест";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Карты не совпадает с ожидаемым");
    }
}
