package org.example.ui.steps.kinopoisk;

import io.qameta.allure.Step;
import org.example.ui.pages.kinopoisk.KinopoiskMainPage;
import org.example.ui.steps.BaseSteps;
import org.openqa.selenium.WebDriver;

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
}
