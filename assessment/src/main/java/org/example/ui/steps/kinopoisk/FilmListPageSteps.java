package org.example.ui.steps.kinopoisk;

import com.google.common.base.Strings;
import io.qameta.allure.Step;
import org.example.ui.pages.kinopoisk.FilmListPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class FilmListPageSteps extends BaseSteps {
    private final FilmListPage page;

    public FilmListPageSteps(WebDriver driver) {
        page = new FilmListPage(driver);
    }

    @Override
    @Step("Проверить, что главная страница Кинопоиск была загружена")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Нажать на ссылку на 250 лучших фильмов")
    public void clickTop250FilmsLink() {
        page.clickTop250FilmsLink();
    }

    @Step("Проверить, что первый фильм из списка это '{filmName}', выпущенный в {filmReleaseYear}")
    public void checkFirstFilmNameAndReleaseYear(String filmName, int filmReleaseYear) {
        List<String> titles = page.getFirstFilmResultTitles();
        if (titles.isEmpty()) {
            Assertions.fail("Не удалось получить информацию по первому фильму из списка");
        }
        String actualFileName = titles.stream()
                .filter(title -> title.contains(filmName))
                .findFirst()
                .orElse("");
        String actualReleaseYear = titles.stream()
                .filter(title -> title.contains(String.valueOf(filmReleaseYear)))
                .findFirst()
                .orElse("");
        Assertions.assertFalse(actualFileName.isEmpty(), "Название первого фильма из списка не совпадает с ожидаемым");
        Assertions.assertFalse(actualReleaseYear.isEmpty(), "Год выхода фильма в прокат не совпадает с ожидаемым");
    }
}
