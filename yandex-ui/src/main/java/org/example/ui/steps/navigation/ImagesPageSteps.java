package org.example.ui.steps.navigation;

import io.qameta.allure.Step;
import org.example.ui.pages.navigation.ImagesPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ImagesPageSteps extends BaseSteps {
    private final ImagesPage page;

    public ImagesPageSteps(WebDriver driver) {
        page = new ImagesPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Картинки")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Картинки была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "Яндекс.Картинки: поиск изображений в интернете, поиск по изображению";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Картинки не совпадает с ожидаемым");
    }
}
