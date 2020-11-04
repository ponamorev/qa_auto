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
    }

    @Step(value = "Ожидание загрузки новой страницы после введения пароля")
    public void waitForNewPageLoadingAfterPasswordSubmitting() {
        Assertions.assertTrue(page.isSubmitButtonStale(), "Кнопка подтверждения входа не исчезла, новая страница не загружена");
    }

    @Override
    @Step(value = "Ожидание загрузки страницы с авторизацией")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step(value = "Проверить, что поле ввода пароля пустое")
    public void checkPasswordInputIsEmpty() {
        Assertions.assertTrue(page.isPasswordInputEmpty(), "Поле ввода пароля не пустое");
    }

    @Step(value = "Проверить наличие сообщения о неверном пароле")
    public void checkWrongPasswordErrorExists() {
        Assertions.assertEquals("Неверный пароль", page.getErrorMessageText(),
                "Сообщение о неверном пароле отсутствует");
    }

    @Step(value = "Проверить наличие сообщения о несуществующем аккаунте")
    public void checkWrongLoginNameErrorExists() {
        Assertions.assertEquals("Такого аккаунта нет", page.getErrorMessageText(),
                "Сообщение об отсутствующем аккаунте отсутствует");
    }
}