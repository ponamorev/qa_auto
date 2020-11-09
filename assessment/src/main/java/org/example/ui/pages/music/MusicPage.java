package org.example.ui.pages.music;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MusicPage extends BasePage {
    private final By closeYandexPlusOfferHeaderButton = By.cssSelector(".payment-plus__header-close");
    private final By musicSearchInput = By.cssSelector(".d-input__field.deco-input.deco-input_suggest");

    public MusicPage(WebDriver driver) {
        super(driver);
    }

    public void clickCloseYandexPlusOfferHeaderButton() {
        getClickableElement(closeYandexPlusOfferHeaderButton).click();
    }

    public void clearMusicSearchInput() {
        getClickableElement(musicSearchInput).clear();
    }

    public void clickMusicSearchInput() {
        getClickableElement(musicSearchInput).click();
    }

    public void sendSearchStringToInput(String text) {
        getClickableElement(musicSearchInput).sendKeys(text);
    }

    public void clickSuggestingArtistFromList(String artist) {
        String artistSearchSuggestLocator = "//div[@class='d-suggest__entities']//div[contains(@class,'d-suggest__items_type_artist')]//div[text()='%s']/parent::div/preceding-sibling::a";
        By artistSearchSuggest = By.xpath(String.format(artistSearchSuggestLocator, artist));
        getClickableElement(artistSearchSuggest).click();
    }
}
