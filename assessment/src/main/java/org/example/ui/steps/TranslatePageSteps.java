package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.TranslatePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TranslatePageSteps extends BaseSteps {
    private final TranslatePage page;

    public TranslatePageSteps(WebDriver driver) {
        page = new TranslatePage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Переводчик")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step(value = "Проверить, что страница с Яндекс.Переводчик была загружена")
    public void checkPageHaveBeenLoaded() {
        String expectedPageTitle = "Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Переводчик не совпадает с ожидаемым");
    }
}
