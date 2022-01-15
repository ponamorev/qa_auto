package org.example.ui.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonSettingsPage extends SettingsBasePage {
    private final By languageSelectButton = By.xpath("//select[@name='intl']/preceding-sibling::button");
    private final By submitButton = By.xpath("//button[@type='submit']");

    public CommonSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickLanguageSelect() {
        getClickableElement(languageSelectButton).click();
    }

    public void chooseLanguage(String lang) {
        String languageOptionTemplate = "//span[text()='%s']/parent::div";
        getClickableElement(By.xpath(String.format(languageOptionTemplate, lang))).click();
    }

    public void clickSubmitButton() {
        getClickableElement(submitButton).click();
    }
}
