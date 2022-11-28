package org.example.ui.pages.settings;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class SettingsBasePage extends BasePage {
    private final By languageTabButton = By.xpath("//a[@data-statlog='tabs.common']");

    protected SettingsBasePage(WebDriver driver) {
        super(driver);
    }

    public void switchToLanguageTab() {
        getClickableElement(languageTabButton).click();
    }
}
