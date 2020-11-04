package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.VideoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class VideoPageSteps extends BaseSteps {
    private final VideoPage page;

    public VideoPageSteps(WebDriver driver) {
        page = new VideoPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Видео")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step(value = "Проверить, что страница с Яндекс.Видео была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Подборки видео для вас — Яндекс.Видео";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Видео не совпадает с ожидаемым");
    }
}