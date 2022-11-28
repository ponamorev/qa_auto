package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.search.SearchResultPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Поиск")
public class YandexSearchTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private SearchResultPageSteps searchResultSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        searchResultSteps = new SearchResultPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка поиска по ключевым словам с использованием расширенных настроек")
    public void checkAdvancedSearchWithKeyWordsTest() {
        String keywords = "Andersen Пенза";
        String advancedSearchCheckBox = "В Пензе";
        String expectedDomain = "andersenlab.com";

        mainSteps.waitForPageToBeLoaded();
        mainSteps.sendTextToSearchAndSubmit(keywords);
        searchResultSteps.waitForPageToBeLoaded();
        searchResultSteps.clickAdvancedSearchSettingsButton();
        searchResultSteps.chooseAdvancedSearchCriteria(advancedSearchCheckBox);
        searchResultSteps.submitAdvancedSearchSettings();
        searchResultSteps.waitForPageToBeLoaded();
        searchResultSteps.checkFirstResultLinkDomain(expectedDomain);
    }

    @Test
    @DisplayName("Проверка агрегированного результата поиска по запросу")
    public void checkAggregatedSearchResultTest() {
        String searchText = "Побег из Шоушенка";
        int releaseYear = 1994;

        mainSteps.waitForPageToBeLoaded();
        mainSteps.sendTextToSearchAndSubmit(searchText);
        searchResultSteps.waitForPageToBeLoaded();
        searchResultSteps.checkFilmNameAndYearFromSearchResultsEntity(searchText, releaseYear);
    }
}
