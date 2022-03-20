package org.example.ui.steps.navigation;

import io.qameta.allure.Step;
import org.example.ui.pages.navigation.VideoPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class VideoPageSteps extends BaseSteps {
    private final VideoPage page;

    public VideoPageSteps(WebDriver driver) {
        page = new VideoPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Видео")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Видео была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "видео: 4 тыс. видео найдено в Яндексе";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Видео не совпадает с ожидаемым");
    }
}
