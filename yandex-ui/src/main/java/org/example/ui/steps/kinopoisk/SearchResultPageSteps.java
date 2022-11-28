package org.example.ui.steps.kinopoisk;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.kinopoisk.SearchResultPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

@Slf4j
public class SearchResultPageSteps extends BaseSteps {
    private final SearchResultPage page;

    public SearchResultPageSteps(WebDriver driver) {
        page = new SearchResultPage(driver);
    }

    @Override
    @Step("Проверить, что страница с результатами расширенного поиска была загружена")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что название первого фильма и год выпуска совпадают с '{expectedFilmName}' и {expectedReleaseYear}")
    public void checkFirstResultFilmNameAndReleaseYear(String expectedFilmName, int expectedReleaseYear) {
        Assertions.assertEquals(expectedFilmName, page.getFilmName(1),
                "Название фильма не совпадает с ожидаемым");
        try {
            Assertions.assertEquals(expectedReleaseYear, Integer.parseInt(page.getFilmReleaseYear(1)),
                    "Год выпуска фильма в прокат не совпадает с ожидаемым");
        } catch (NumberFormatException e) {
            log.error("Проблема при конвертации года выпуска фильма в прокат из строки в число");
            LogToAllure.logError("Проблема при конвертации года выпуска фильма в прокат из строки в число");
            Assertions.fail("Проблема при конвертации года выпуска фильма в прокат из строки в число");
        }
    }
}
