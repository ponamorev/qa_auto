package org.example.ui.steps;

import com.google.common.collect.Lists;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@Slf4j
abstract class BaseSteps {
    @Step(value = "Переключиться на вторую вкладку")
    public void switchToNewTabAndClosePrevious(WebDriver driver) {
        String currentTab = driver.getWindowHandle();
        ArrayList<String> tabs = Lists.newArrayList(driver.getWindowHandles());
        if (tabs.size() > 2) {
            log.error("Открыто больше двух вкладок");
            Assertions.fail("Должно быть открыто только две вкладки");
        }
        driver.close();
        tabs.remove(currentTab);
        String newTab = Lists.newArrayList(tabs).get(0);
        driver.switchTo().window(newTab);
    }

    @Step(value = "Ожидание загрузки страницы")
    public abstract void waitForPageToBeLoaded();
}
