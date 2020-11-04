package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends BaseSteps {
    private final MainPage page;

    public MainPageSteps(WebDriver driver) {
        page = new MainPage(driver);
    }

    @Step(value = "Нажать кнопку входа в аккаунт")
    public void clickLoginButton() {
        page.clickLoginButton();
    }

    @Override
    @Step(value = "Ожидание загрузки основной страницы")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step(value = "Нажать кнопку '{section}'")
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
}
