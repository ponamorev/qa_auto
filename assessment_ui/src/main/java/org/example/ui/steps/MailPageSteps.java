package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.MailPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MailPageSteps extends BaseSteps {
    private final MailPage page;

    public MailPageSteps(WebDriver driver) {
        page = new MailPage(driver);
    }

    @Step(value = "Нажать кнопку аккаунта и проверить, что там содержится имя пользователя")
    public void clickAccountAndCheckUserNameIsContained(String expectedUserName) {
        page.clickAccountButton();
        Assertions.assertTrue(page.getUserName().contains(expectedUserName),
                "Имя пользователя не совпадает с ожидаемым");
    }
}
