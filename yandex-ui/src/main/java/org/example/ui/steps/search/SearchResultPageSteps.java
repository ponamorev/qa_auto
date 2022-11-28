package org.example.ui.steps.search;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.search.SearchResultPage;
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
    @Step("Ожидание загрузки страницы с результатами поиска")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что домен из ссылки первого результата равен '{expectedDomain}")
    public void checkFirstResultLinkDomain(String expectedDomain) {
        String actualDomain = page.getFirstResultLinkAddress()
                .replaceAll("[htps]*://", "")
                .replaceAll("/.*", "");
        Assertions.assertEquals(expectedDomain, actualDomain,
                "Домен в ссылке не совпадает с ожидаемым");
    }

    @Step("Перейти к расширенным настройкам поиска")
    public void clickAdvancedSearchSettingsButton() {
        page.clickAdvancedSearchSettingsButton();
    }

    @Step("Выбрать '{name}' критерий в расширенном поиске")
    public void chooseAdvancedSearchCriteria(String name) {
        page.chooseAdvancedSearchCheckBox(name);
    }

    @Step("Подтвердить выбранные расширенные настройки")
    public void submitAdvancedSearchSettings() {
        page.clickSubmitAdvancedSearchSettingsButton();
    }

    @Step("Проверить название и год фильма в содержимом результатов поиска")
    public void checkFilmNameAndYearFromSearchResultsEntity(String filmName, int releaseYear) {
        String actualFilmName = page.getEntityHeaderTitle();
        String actualReleaseYearString = "";
        int actualReleaseYear = 0;
        try {
            actualReleaseYearString = page.getEntityHeaderSubtitle()
                    .replaceAll("\\d+\\+", "")
                    .replaceAll("\\D", "");
            actualReleaseYear = Integer.parseInt(actualReleaseYearString);
        } catch (NumberFormatException e) {
            log.error("Проблема с конвертацией года выпуска фильма, исходная строка: {}", actualReleaseYearString);
            LogToAllure.logError("Проблема с конвертацией года выпуска фильма, исходная строка: {}", actualReleaseYearString);
            Assertions.fail("Проблема с конвертацией года выпуска фильма, исходная строка: " + actualReleaseYearString);
        }

        Assertions.assertEquals(filmName, actualFilmName,
                "Название фильма не совпадает с ожидаемым");
        Assertions.assertEquals(releaseYear, actualReleaseYear,
                "Год выпуска фильма в прокат не совпадает с ожидаемым");
    }
}
