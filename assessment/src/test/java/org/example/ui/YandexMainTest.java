package org.example.ui;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.steps.BaseSteps;
import org.example.ui.steps.ImagesPageSteps;
import org.example.ui.steps.LoginPageSteps;
import org.example.ui.steps.MailPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.MapsPageSteps;
import org.example.ui.steps.MarketPageSteps;
import org.example.ui.steps.MusicPageSteps;
import org.example.ui.steps.NewsPageSteps;
import org.example.ui.steps.TranslatePageSteps;
import org.example.ui.steps.VideoPageSteps;
import org.example.ui.steps.settings.LanguageSettingsPageSteps;
import org.example.ui.steps.settings.SearchSettingsPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class YandexMainTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private LoginPageSteps loginSteps;
    private MailPageSteps mailSteps;
    private VideoPageSteps videoSteps;
    private ImagesPageSteps imagesSteps;
    private NewsPageSteps newsSteps;
    private MapsPageSteps mapsSteps;
    private MarketPageSteps marketSteps;
    private TranslatePageSteps translateSteps;
    private MusicPageSteps musicSteps;
    private LanguageSettingsPageSteps languageSteps;
    private SearchSettingsPageSteps searchSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        loginSteps = new LoginPageSteps(driver);
        mailSteps = new MailPageSteps(driver);
        videoSteps = new VideoPageSteps(driver);
        imagesSteps = new ImagesPageSteps(driver);
        newsSteps = new NewsPageSteps(driver);
        mapsSteps = new MapsPageSteps(driver);
        marketSteps = new MarketPageSteps(driver);
        translateSteps = new TranslatePageSteps(driver);
        musicSteps = new MusicPageSteps(driver);
        languageSteps = new LanguageSettingsPageSteps(driver);
        searchSteps = new SearchSettingsPageSteps(driver);
    }

    @Test
    @DisplayName(value = "Проверка перехода на основные сервисы Яндекс")
    public void mainPageNavigationSteps() {
        checkNavigationToPage(videoSteps, "Видео");
        checkNavigationToPage(imagesSteps, "Картинки");
        checkNavigationToPage(newsSteps, "Новости");
        checkNavigationToPage(mapsSteps, "Карты");
        checkNavigationToPage(marketSteps, "Маркет");
        checkNavigationToPage(translateSteps, "Переводчик");
        checkNavigationToPage(musicSteps, "Музыка");
    }

    @Test
    @DisplayName(value = "Проверка переключения языка отображения")
    public void changeLanguageTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.goToLoginPage(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.logInToAccount(loginName, loginPass);
        mailSteps.waitForPageToBeLoaded();
        mailSteps.clickYandexHomeButton();
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
        searchSteps.clickTabButton("Язык");
        languageSteps.waitForPageToBeLoaded();
        languageSteps.chooseRussianLanguage();
    }

    private void checkNavigationToPage(BaseSteps steps, String section) {
        driver.get(yandexMainPageUrl);
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickNavigationButton(section);
        mainSteps.switchToNewTabAndClosePrevious(driver);
        steps.waitForPageToBeLoaded();
        steps.checkPageHaveBeenLoaded();
    }
}
