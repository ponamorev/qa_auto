package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class MainPageSteps extends BaseSteps {
    private final MainPage page;

    public MainPageSteps(WebDriver driver) {
        page = new MainPage(driver);
    }

    @Step("Нажать кнопку входа в аккаунт")
    public void clickLoginButton() {
        page.clickLoginButton();
    }

    @Override
    @Step("Ожидание загрузки основной страницы")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Нажать кнопку '{section}'")
    public void clickNavigationButton(String section) {
        switch(section) {
            case "Видео":
                page.clickVideoButton();
                break;
            case "Картинки":
                page.clickImagesButton();
                break;
            case "Новости":
                page.clickNewsButton();
                break;
            case "Карты":
                page.clickMapsButton();
                break;
            case "Маркет":
                page.clickMarketButton();
                break;
            case "Переводчик":
                page.clickTranslateButton();
                break;
            case "Музыка":
                page.clickMusicButton();
                break;
            default:
                Assertions.fail(String.format("Раздел %s отсутствует на главной странице Яндекс", section));
        }
    }

    @Step("Перейти на страницу Кинопоиска")
    public void goToKinopoiskPage() {
        page.clickMoreMenuButton();
        page.clickKinopoiskButton();
    }

    @Step("Перейти на страницу настроек")
    public void goToSettingsPage() {
        page.clickSettingsDropDownMenuButton();
        page.clickPortalSettingsButton();
    }

    @Step("Нажать кнопку 'Ещё' рядом с котировками")
    public void clickMoreStocksButton() {
        page.clickMoreStocksButton();
    }

    @Step("Проверить, что курс доллара больше {rubles}")
    public void checkDollarsCurrencyRateMoreThanExpected(BigDecimal rubles) {
        Assertions.assertTrue(page.getDollarCurrencyRate().compareTo(rubles) > 0,
                String.format("Курс доллара меньше %s за 1$", rubles.toString()));
    }
}
