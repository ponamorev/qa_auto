package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.kinopoisk.FilmListPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskFilmPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskMainPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KinopoiskTest extends BaseYandexTest {
    private final String shawshankRedemptionFilm = "Побег из Шоушенка";
    private final int shawshankRedemptionFilmReleaseYear = 1994;

    private MainPageSteps mainSteps;
    private KinopoiskMainPageSteps kinopoiskMainSteps;
    private KinopoiskFilmPageSteps kinopoiskFilmSteps;
    private FilmListPageSteps filmListSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        kinopoiskMainSteps = new KinopoiskMainPageSteps(driver);
        kinopoiskFilmSteps = new KinopoiskFilmPageSteps(driver);
        filmListSteps = new FilmListPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка поиска фильма на Кинопоиске")
    public void kinopoiskFilmSearchTest() {
        String searchText = "Побег из Ш";

        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToKinopoiskPage();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        kinopoiskMainSteps.waitForPageToBeLoaded();
        kinopoiskMainSteps.sendTextToSearchInput(searchText);
        kinopoiskMainSteps.chooseFilmFromSuggested(1);
        kinopoiskFilmSteps.waitForPageToBeLoaded();
        kinopoiskFilmSteps.checkFilmNameAndReleaseYear(shawshankRedemptionFilm, shawshankRedemptionFilmReleaseYear);
    }

    @Test
    @DisplayName("Проверка первого фильма из списка 250 лучших фильмов")
    public void checkFirstFilmFromListTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToKinopoiskPage();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        kinopoiskMainSteps.waitForPageToBeLoaded();
        kinopoiskMainSteps.clickFilmListLink();
        filmListSteps.waitForPageToBeLoaded();
        filmListSteps.clickTop250FilmsLink();
        filmListSteps.waitForPageToBeLoaded();
        filmListSteps.checkFirstFilmNameAndReleaseYear(shawshankRedemptionFilm, shawshankRedemptionFilmReleaseYear);
    }
}
