package org.example.ui.steps.settings;

import io.qameta.allure.Step;
import org.example.ui.pages.settings.CommonSettingsPage;
import org.openqa.selenium.WebDriver;

public class CommonSettingsPageSteps extends SettingsBaseSteps {
    private final CommonSettingsPage page;

    public CommonSettingsPageSteps(WebDriver driver) {
        page = new CommonSettingsPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с языковыми настройками Яндекс")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Выбрать английский язык в списке языков")
    public void chooseEnglishLanguage() {
        page.clickLanguageSelect();
        page.chooseLanguage("English");
        page.clickSubmitButton();
    }

    @Step("Выбрать русский язык в списке языков")
    public void chooseRussianLanguage() {
        page.clickLanguageSelect();
        page.chooseLanguage("Русский");
        page.clickSubmitButton();
    }
}
