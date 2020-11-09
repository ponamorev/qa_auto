package org.example.ui.steps.settings;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.settings.SettingsBasePage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;

@Slf4j
public abstract class SettingsBaseSteps extends BaseSteps {
    @Step("Переключиться на вкладку '{tabName}' в настройках Яндекс")
    protected void clickTabButton(String tabName, SettingsBasePage page) {
        if (tabName.equals("Язык")) {
            page.switchToLanguageTab();
        } else {
            log.error("Вкладка {} не добавлена для перехода, необходимо дополнить метод", tabName);
            LogToAllure.logError("Вкладка {} не добавлена для перехода, необходимо дополнить метод", tabName);
            Assertions.fail(String.format("Вкладка %s не добавлена для перехода, необходимо дополнить метод", tabName));
        }
    }
}
