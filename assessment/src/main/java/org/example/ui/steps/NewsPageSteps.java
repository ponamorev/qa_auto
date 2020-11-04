package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.NewsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class NewsPageSteps extends BaseSteps {
    private final NewsPage page;

    public NewsPageSteps(WebDriver driver) {
        page = new NewsPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Новости")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step(value = "Проверить, что страница с Яндекс.Новости была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Новости не совпадает с ожидаемым");
    }
}
