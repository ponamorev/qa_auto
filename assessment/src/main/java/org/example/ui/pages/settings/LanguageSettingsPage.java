package org.example.ui.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageSettingsPage extends SettingsBasePage {
    private final By selectLanguageDropDownButton = By.cssSelector(".select__button");
    private final By englishLanguageOption = By.xpath("//span[text()='English']/parent::div");
    private final By russianLanguageOption = By.xpath("//span[text()='Русский']/parent::div");
    private final By submitButton = By.xpath("//button[@type='submit']");

    public LanguageSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectLanguageButton() {
        getClickableElement(selectLanguageDropDownButton).click();
    }

    public void chooseEnglishLanguage() {
        getClickableElement(englishLanguageOption).click();
    }

    public void chooseRussianLanguage() {
        getClickableElement(russianLanguageOption).click();
    }

    public void clickSubmitButton() {
        getClickableElement(submitButton).click();
    }
}
