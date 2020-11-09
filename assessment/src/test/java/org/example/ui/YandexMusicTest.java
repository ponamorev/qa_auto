package org.example.ui;

import org.example.ui.steps.LoginPageSteps;
import org.example.ui.steps.MailPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.music.ArtistPageSteps;
import org.example.ui.steps.music.MusicPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Яндекс.Музыка")
public class YandexMusicTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private LoginPageSteps loginSteps;
    private MailPageSteps mailSteps;
    private MusicPageSteps musicSteps;
    private ArtistPageSteps artistSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        loginSteps = new LoginPageSteps(driver);
        mailSteps = new MailPageSteps(driver);
        musicSteps = new MusicPageSteps(driver);
        artistSteps = new ArtistPageSteps(driver);

        logIn();
    }

    @Test
    @DisplayName("Проверка страницы с исполнителем на Яндекс.Музыке")
    public void artistPageTest() {
        String artist = "Metallica";
        musicSteps.sendArtistToSearch(artist);
        musicSteps.chooseArtistFromDropDownSuggestList(artist);
        artistSteps.waitForPageToBeLoaded();
        artistSteps.checkArtistNameEqualToExpected(artist);
        artistSteps.checkPopularAlbumsArtistEqualTo(artist);
    }

    @Test
    @DisplayName("Проверка воспроизведения музыки")
    public void playMusicTest() {
        String searchText = "beyo";
        String artist = "Beyoncé";
        musicSteps.sendArtistToSearch(searchText);
        musicSteps.chooseArtistFromDropDownSuggestList(artist);
        artistSteps.waitForPageToBeLoaded();
        artistSteps.playFirstPopularSong();
        artistSteps.checkSongIsPlaying();
    }

    private void logIn() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        loginSteps.waitForNewPageLoadingAfterPasswordSubmitting();
        mailSteps.waitForPageToBeLoaded();
        driver.get(yandexMainPageUrl);
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickNavigationButton("Музыка");
        mainSteps.switchToNewTabAndClosePrevious(driver);
        musicSteps.waitForPageToBeLoaded();
        musicSteps.closeYandexPlusOffer();
    }
}
