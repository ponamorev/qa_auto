package org.example.ui.steps.navigation;

import io.qameta.allure.Step;
import org.example.ui.pages.navigation.TranslatePage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TranslatePageSteps extends BaseSteps {
    private final TranslatePage page;

    public TranslatePageSteps(WebDriver driver) {
        page = new TranslatePage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Переводчик")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Переводчик была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Переводчик не совпадает с ожидаемым");
    }
}
