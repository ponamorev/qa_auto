package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.MarketPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MarketPageSteps extends BaseSteps {
    private final MarketPage page;

    public MarketPageSteps(WebDriver driver) {
        page = new MarketPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Маркет")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step(value = "Проверить, что страница с Яндекс.Маркет была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Маркет не совпадает с ожидаемым");
    }
}
