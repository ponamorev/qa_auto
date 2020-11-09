package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.settings.LanguageSettingsPageSteps;
import org.example.ui.steps.settings.SearchSettingsPageSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Язык")
public class LanguageYandexTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private LanguageSettingsPageSteps languageSteps;
    private SearchSettingsPageSteps searchSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        languageSteps = new LanguageSettingsPageSteps(driver);
        searchSteps = new SearchSettingsPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка переключения языка отображения")
    public void changeLanguageTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.clickTabButton("Язык");
        languageSteps.waitForPageToBeLoaded();
        languageSteps.chooseEnglishLanguage();
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.checkLanguageChangedToEnglish();
    }

    @AfterEach
    public void languageTestTearDown() {
        driver.get(yandexMainPageUrl);
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.clickTabButton("Язык");
        languageSteps.waitForPageToBeLoaded();
        languageSteps.chooseRussianLanguage();
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.checkLanguageChangedToRussian();
        tearDown();
    }
}
