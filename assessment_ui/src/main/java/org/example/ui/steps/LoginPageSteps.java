package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps extends BaseSteps {
    private final LoginPage page;

    public LoginPageSteps(WebDriver driver) {
        page = new LoginPage(driver);
    }

    @Step(value = "Ввести логин и нажать кнопку 'Войти'")
    public void setLoginAndSubmit(String login) {
        page.clickLoginNameInput();
        page.loginNameInputSendKeys(login);
        page.clickSubmitButton();
    }

    @Step(value = "Ввести пароль и нажать кнопку 'Войти'")
    public void setPasswordAndSubmit(String password) {
        page.clickLoginPasswordInput();
        page.loginPasswordInputSendKeys(password);
        page.clickSubmitButton();
        Assertions.assertTrue(page.isSubmitButtonStale(), "Кнопка подтверждения входа не исчезла, новая страница не загружена");
    }

    @Step(value = "Ожидание загрузки страницы с авторизацией")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }
}
