package org.example.ui;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.steps.BaseSteps;
import org.example.ui.steps.navigation.ImagesPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.maps.MapsPageSteps;
import org.example.ui.steps.market.MarketPageSteps;
import org.example.ui.steps.music.MusicPageSteps;
import org.example.ui.steps.navigation.NewsPageSteps;
import org.example.ui.steps.navigation.TranslatePageSteps;
import org.example.ui.steps.navigation.VideoPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@Slf4j
@DisplayName("Главная страница")
public class YandexMainTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private VideoPageSteps videoSteps;
    private ImagesPageSteps imagesSteps;
    private NewsPageSteps newsSteps;
    private MapsPageSteps mapsSteps;
    private MarketPageSteps marketSteps;
    private TranslatePageSteps translateSteps;
    private MusicPageSteps musicSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        videoSteps = new VideoPageSteps(driver);
        imagesSteps = new ImagesPageSteps(driver);
        newsSteps = new NewsPageSteps(driver);
        mapsSteps = new MapsPageSteps(driver);
        marketSteps = new MarketPageSteps(driver);
        translateSteps = new TranslatePageSteps(driver);
        musicSteps = new MusicPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка перехода на основные сервисы Яндекс")
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
    @DisplayName("Проверка, что курс доллара по-прежнему больше 70 рублей за 1$")
    public void dollarToRubleTest() {
        BigDecimal rubles = new BigDecimal("70");

        mainSteps.waitForPageToBeLoaded();
        mainSteps.checkDollarsCurrencyRateMoreThanExpected(rubles);
    }

    private void checkNavigationToPage(BaseSteps steps, String section) {
        driver.get(yandexMainPageUrl);
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickNavigationButton(section);
        mainSteps.switchToNewTabAndClosePrevious(driver);
        steps.waitForPageToBeLoaded();
        steps.checkPageHasBeenLoaded();
    }
}
