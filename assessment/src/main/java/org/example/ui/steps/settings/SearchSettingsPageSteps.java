package org.example.ui.steps.settings;

import io.qameta.allure.Step;
import org.example.ui.pages.settings.SearchSettingsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchSettingsPageSteps extends SettingsBaseSteps {
    private final SearchSettingsPage page;

    public SearchSettingsPageSteps(WebDriver driver) {
        page = new SearchSettingsPage(driver);
    }

    @Override
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    public void clickTabButton(String tabName) {
        clickTabButton(tabName, page);
    }

    @Step(value = "Проверить, что язык был изменен на английский")
    public void checkLanguageChangedToEnglish() {
        String expectedPageTitle = "Search — Yandex settings";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы не на английском языке");
    }
}
