package org.example.ui.steps.settings;

import io.qameta.allure.Step;
import org.example.ui.pages.settings.LanguageSettingsPage;
import org.openqa.selenium.WebDriver;

public class LanguageSettingsPageSteps extends SettingsBaseSteps {
    private final LanguageSettingsPage page;

    public LanguageSettingsPageSteps(WebDriver driver) {
        page = new LanguageSettingsPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы с языковыми настройками Яндекс")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step(value = "Выбрать английский язык в списке языков")
    public void chooseEnglishLanguage() {
        page.clickSelectLanguageButton();
        page.chooseEnglishLanguage();
        page.clickSubmitButton();
    }

    @Step(value = "Выбрать русский язык в списке языков")
    public void chooseRussianLanguage() {
        page.clickSelectLanguageButton();
        page.chooseRussianLanguage();
        page.clickSubmitButton();
    }
}
