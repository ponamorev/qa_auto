package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.settings.CommonSettingsPageSteps;
import org.example.ui.steps.settings.SearchSettingsPageSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Язык")
public class SettingsYandexTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private CommonSettingsPageSteps commonSettingsSteps;
    private SearchSettingsPageSteps searchSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        commonSettingsSteps = new CommonSettingsPageSteps(driver);
        searchSteps = new SearchSettingsPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка переключения языка отображения")
    public void changeLanguageTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.clickTabButton("Общие настройки");
        commonSettingsSteps.waitForPageToBeLoaded();
        commonSettingsSteps.chooseEnglishLanguage();
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
        searchSteps.clickTabButton("Общие настройки");
        commonSettingsSteps.waitForPageToBeLoaded();
        commonSettingsSteps.chooseRussianLanguage();
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToSettingsPage();
        searchSteps.waitForPageToBeLoaded();
        searchSteps.checkLanguageChangedToRussian();
        tearDown();
    }
}
