package org.example.ui.steps;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;
import org.example.ui.LogToAllure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseSteps {
    @Step("Переключиться на вторую вкладку")
    public void switchToNewTabAndClosePrevious(WebDriver driver) {
        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        if (tabs.size() == 1) {
            Awaitility.await().atMost(10, TimeUnit.SECONDS)
                    .until(() -> driver.getWindowHandles().size() > 1);
            tabs = driver.getWindowHandles();
        }
        if (tabs.size() != 2) {
            LogToAllure.logError(log, "Открыто больше двух вкладок");
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            Assertions.fail("Должно быть открыто только две вкладки");
        }
        driver.close();
        tabs.remove(currentTab);
        Iterator<String> tabsIterator = tabs.iterator();
        String newTab = tabsIterator.next();
        driver.switchTo().window(newTab);
    }

    public abstract void waitForPageToBeLoaded();

    public void checkPageHaveBeenLoaded() {
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    private static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
