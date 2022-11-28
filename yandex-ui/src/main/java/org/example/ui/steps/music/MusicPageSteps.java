package org.example.ui.steps.music;

import io.qameta.allure.Step;
import org.example.ui.pages.music.MusicPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MusicPageSteps extends BaseSteps {
    private final MusicPage page;

    public MusicPageSteps(WebDriver driver) {
        page = new MusicPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Музыка")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Музыка была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "Яндекс.Музыка — собираем музыку и подкасты для вас";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Музыка не совпадает с ожидаемым");
    }

    @Step("Закрыть предложение о покупке Яндекс.Плюс")
    public void closeYandexPlusOffer() {
        page.clickCloseYandexPlusOfferHeaderButton();
    }

    @Step("Ввести в поиск артиста {artistName}")
    public void sendArtistToSearch(String artistName) {
        page.clearMusicSearchInput();
        page.clickMusicSearchInput();
        page.sendSearchStringToInput(artistName);
        page.waitForPageToBeLoaded();
    }

    @Step("Выбрать {artistName} из выпадающего списка с предложениями")
    public void chooseArtistFromDropDownSuggestList(String artistName) {
        page.clickSuggestingArtistFromList(artistName);
    }
}
