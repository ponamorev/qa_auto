package org.example.ui.pages.music;

import org.example.ui.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ArtistPage extends BasePage {
    private final By artistName = By.cssSelector(".d-generic-page-head__main-top h1");
    private final By popularAlbums = By.cssSelector(".page-artist__albums .d-artists a");
    private final By playingSong = By.cssSelector(".button-play__type_track.button-play_playing");

    public ArtistPage(WebDriver driver) {
        super(driver);
    }

    public String getArtistName() {
        return getElement(artistName).getText();
    }

    public List<WebElement> getArtistsPopularAlbums() {
        return driver.findElements(popularAlbums);
    }

    public boolean isPlayingSongExists() {
        return driver.findElements(playingSong).size() > 0;
    }

    public void clickPopularSongByIndex(int index) {
        String playButtonClass = "button-play__type_track";
        String playButtonLocator = "//button[contains(@class,'button-play__type_track')][%d]";
        WebElement button = getClickableElement(By.xpath(String.format(playButtonLocator, index)));
        Assertions.assertNotNull(button, String.format("Не удается получить элемент %s", button));
        String jsScript = String.format("document.getElementsByClassName('%s')[%d].click()", playButtonClass, index - 1);
        ((JavascriptExecutor) driver).executeScript(jsScript);
    }
}
