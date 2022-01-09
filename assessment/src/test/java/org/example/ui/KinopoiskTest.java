package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.kinopoisk.AdvancedSearchPageSteps;
import org.example.ui.steps.kinopoisk.FilmListPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskFilmPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskMainPageSteps;
import org.example.ui.steps.kinopoisk.SearchResultPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Кинопоиск")
public class KinopoiskTest extends BaseYandexTest {

    private MainPageSteps mainSteps;
    private KinopoiskMainPageSteps kinopoiskMainSteps;
    private KinopoiskFilmPageSteps kinopoiskFilmSteps;
    private FilmListPageSteps filmListSteps;
    private AdvancedSearchPageSteps advancedSearchSteps;
    private SearchResultPageSteps searchResultSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        kinopoiskMainSteps = new KinopoiskMainPageSteps(driver);
        kinopoiskFilmSteps = new KinopoiskFilmPageSteps(driver);
        filmListSteps = new FilmListPageSteps(driver);
        advancedSearchSteps = new AdvancedSearchPageSteps(driver);
        searchResultSteps = new SearchResultPageSteps(driver);

        goToKinopoisk();
    }

    @Test
    @DisplayName("Проверка поиска фильма на Кинопоиске")
    public void kinopoiskFilmSearchTest() {
        String searchText = "Побег из Ш";
        String shawshankRedemptionFilm = "Побег из Шоушенка (1994)";
        int shawshankRedemptionFilmReleaseYear = 1994;

        kinopoiskMainSteps.sendTextToSearchInput(searchText);
        kinopoiskMainSteps.chooseFilmFromSuggested(1);
        kinopoiskFilmSteps.waitForPageToBeLoaded();
        kinopoiskFilmSteps.checkFilmNameAndReleaseYear(shawshankRedemptionFilm, shawshankRedemptionFilmReleaseYear);
    }

    @Test
    @DisplayName("Проверка первого фильма из списка 250 лучших фильмов")
    public void checkFirstFilmFromListTest() {
        String filmName = "Зеленая миля";
        int releaseYear = 1999;

        kinopoiskMainSteps.clickFilmListLink();
        filmListSteps.waitForPageToBeLoaded();
        filmListSteps.clickTop250FilmsLink();
        filmListSteps.waitForPageToBeLoaded();
        filmListSteps.checkFirstFilmNameAndReleaseYear(filmName, releaseYear);
    }

    @Test
    @DisplayName("Проверка поиска фильма по расширенному поиску")
    public void advancedFilmSearchingTest() {
        String country = "Россия";
        String sportGenre = "спорт";
        String musicGenre = "музыка";
        int tillYear = 2019;
        String filmName = "Время ДДТ";
        int filmReleaseYear = 2002;

        kinopoiskMainSteps.clickAdvancedSearchSettingsButton();
        advancedSearchSteps.waitForPageToBeLoaded();
        advancedSearchSteps.selectCountry(country);
        advancedSearchSteps.selectGenres(sportGenre, musicGenre);
        advancedSearchSteps.selectTillYear(tillYear);
        advancedSearchSteps.clickSubmitFilmSearchButton();
        searchResultSteps.waitForPageToBeLoaded();
        searchResultSteps.checkFirstResultFilmNameAndReleaseYear(filmName, filmReleaseYear);
    }

    private void goToKinopoisk() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToKinopoiskPage();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        kinopoiskMainSteps.waitForPageToBeLoaded();
    }
}
