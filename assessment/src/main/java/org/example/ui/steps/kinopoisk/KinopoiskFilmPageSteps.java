package org.example.ui.steps.kinopoisk;

import io.qameta.allure.Step;
import org.example.ui.pages.kinopoisk.KinopoiskFilmPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class KinopoiskFilmPageSteps extends BaseSteps {
    private final KinopoiskFilmPage page;

    public KinopoiskFilmPageSteps(WebDriver driver) {
        page = new KinopoiskFilmPage(driver);
    }

    @Override
    @Step("Проверить, что страница с фильмом на Кинопоиске была загружена")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что название фильма и год равны '{expectedFilmName}' и {expectedReleaseYear}")
    public void checkFilmNameAndReleaseYear(String expectedFilmName, int expectedReleaseYear) {
        Assertions.assertEquals(expectedFilmName, page.getFilmName(),
                "Название фильма не совпадает с ожидаемым");
        Assertions.assertEquals(expectedReleaseYear, page.getFilmReleaseYear(),
                "Год выпуска фильма в прокат не совпадает с ожидаемым");
    }
}
