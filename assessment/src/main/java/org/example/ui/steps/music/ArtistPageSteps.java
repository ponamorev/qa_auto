package org.example.ui.steps.music;

import io.qameta.allure.Step;
import org.example.ui.pages.music.ArtistPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistPageSteps extends BaseSteps {
    private final ArtistPage page;

    public ArtistPageSteps(WebDriver driver) {
        page = new ArtistPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с исполнителем на Яндекс.Музыка")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что имя исполнителя совпадает {expectedArtistName}")
    public void checkArtistNameEqualToExpected(String expectedArtistName) {
        Assertions.assertEquals(expectedArtistName, page.getArtistName(),
                "Имя исполнителя не совпадает с ожидаемым");
    }

    @Step("Проверить, что в популярных альбомах имя исполнителя совпадает с {artist}")
    public void checkPopularAlbumsArtistEqualTo(String artist) {
        List<WebElement> albums = page.getArtistsPopularAlbums();
        List<String> artistNames = albums.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        artistNames = artistNames.stream()
                .filter(name -> name.equals(artist))
                .collect(Collectors.toList());
        Assertions.assertEquals(8, artistNames.size(),
                "Не все альбомы имеют исполнителя " + artist);
    }
}
