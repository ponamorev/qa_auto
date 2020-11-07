package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskFilmPageSteps;
import org.example.ui.steps.kinopoisk.KinopoiskMainPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KinopoiskTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private KinopoiskMainPageSteps kinopoiskMainSteps;
    private KinopoiskFilmPageSteps kinopoiskFilmSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        kinopoiskMainSteps = new KinopoiskMainPageSteps(driver);
        kinopoiskFilmSteps = new KinopoiskFilmPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка поиска фильма на Кинопоиске")
    public void kinopoiskFilmSearchTest() {
        String searchText = "Побег из Ш";
        String expectedFilmName = "Побег из Шоушенка";
        int expectedReleaseYear = 1994;

        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToKinopoiskPage();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        kinopoiskMainSteps.waitForPageToBeLoaded();
        kinopoiskMainSteps.sendTextToSearchInput(searchText);
        kinopoiskMainSteps.chooseFilmFromSuggested(1);
        kinopoiskFilmSteps.waitForPageToBeLoaded();
        kinopoiskFilmSteps.checkFilmNameAndReleaseYear(expectedFilmName, expectedReleaseYear);
    }
}
