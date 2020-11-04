package org.example.ui.steps;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.pages.MailPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

@Slf4j
public class MailPageSteps extends BaseSteps {
    private final MailPage page;

    public MailPageSteps(WebDriver driver) {
        page = new MailPage(driver);
    }

    @Step(value = "Нажать кнопку аккаунта и проверить, что там содержится имя пользователя")
    public void clickAccountAndCheckUserNameIsContained(String expectedUserName) {
        page.clickAccountButton();
        String actualUserName = page.getUserName();
        log.debug("Actual user name - {}", actualUserName);
        Assertions.assertTrue(actualUserName.contains(expectedUserName),
                "Имя пользователя не совпадает с ожидаемым");
    }

    @Override
    @Step(value = "Ожидание загрузки страницы Яндекс.Почта")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step(value = "Нажать кнопку выхода из аккаунта")
    public void clickLogOutButton() {
        page.clickAccountButton();
        page.clickLogoutButton();
    }
}
