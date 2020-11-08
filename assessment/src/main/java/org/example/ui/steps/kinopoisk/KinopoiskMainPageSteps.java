package org.example.ui.steps.kinopoisk;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.kinopoisk.KinopoiskMainPage;
import org.example.ui.steps.BaseSteps;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

@Slf4j
public class KinopoiskMainPageSteps extends BaseSteps {
    private final KinopoiskMainPage page;

    public KinopoiskMainPageSteps(WebDriver driver) {
        page = new KinopoiskMainPage(driver);
    }

    @Override
    @Step("Проверить, что главная страница Кинопоиск была загружена")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Ввести текст '{searchText}' в поле поиска")
    public void sendTextToSearchInput(String searchText) {
        page.clearSearchInput();
        page.clickSearchInput();
        page.sendTextToSearchInput(searchText);
    }

    @Step("Выбрать {index}-й элемент из предлагаемых фильмов")
    public void chooseFilmFromSuggested(int index) {
        page.clickSuggestedSearchOption(index);
    }

    @Step("Нажать ссылку на 250 лучших фильмов")
    public void clickFilmListLink() {
        try {
            page.clickDirectFilmListLink();
        } catch (ElementNotVisibleException e) {
            log.warn("Ссылка на список фильмов отсутствует на основном экране");
            LogToAllure.logWarn("Ссылка на список фильмов отсутствует на основном экране");
            page.clickMenuButton();
            page.clickMenuFilmListLink();
        }
    }

    @Step("Перейти к расширенным настройкам поиска")
    public void clickAdvancedSearchSettingsButton() {
        page.clickAdvancedSearchSettingsButton();
    }
}
