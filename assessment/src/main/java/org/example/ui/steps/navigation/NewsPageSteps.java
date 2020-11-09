package org.example.ui.steps.navigation;

import io.qameta.allure.Step;
import org.example.ui.pages.navigation.NewsPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class NewsPageSteps extends BaseSteps {
    private final NewsPage page;

    public NewsPageSteps(WebDriver driver) {
        page = new NewsPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Новости")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Новости была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Новости не совпадает с ожидаемым");
    }
}
