package org.example.ui.pages.music;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArtistPage extends BasePage {
    private final By artistName = By.cssSelector(".d-generic-page-head__main-top h1");
    private final By popularAlbums = By.cssSelector(".page-artist__albums .d-artists a");

    public ArtistPage(WebDriver driver) {
        super(driver);
    }

    public String getArtistName() {
        return getElement(artistName).getText();
    }

    public List<WebElement> getArtistsPopularAlbums() {
        return driver.findElements(popularAlbums);
    }
}
