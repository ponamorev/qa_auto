package org.example.ui.steps.kinopoisk;

import io.qameta.allure.Step;
import org.example.ui.pages.kinopoisk.AdvancedSearchPage;
import org.example.ui.steps.BaseSteps;
import org.openqa.selenium.WebDriver;

public class AdvancedSearchPageSteps extends BaseSteps {
    private final AdvancedSearchPage page;

    public AdvancedSearchPageSteps(WebDriver driver) {
        page = new AdvancedSearchPage(driver);
    }

    @Override
    @Step("Проверить, что страница с расширенным поиском была загружена")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Указать страну '{country}' для поиска фильмов")
    public void selectCountry(String country) {
        page.clickCountrySelect();
        page.selectCountry(country);
    }

    @Step("Указать жанры ({genres}) для поиска фильмов")
    public void selectGenres(String... genres) {
        page.selectGenres(genres);
    }

    @Step("Указать верхнюю границу по дате выхода фильма")
    public void selectTillYear(int year) {
        page.selectTillYear(year);
    }

    @Step("Нажать кнопку 'Поиск'")
    public void clickSubmitFilmSearchButton() {
        page.clickSubmitFilmSearchButton();
    }
}
