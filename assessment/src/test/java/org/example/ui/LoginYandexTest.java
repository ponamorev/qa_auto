package org.example.ui;

import org.example.ui.steps.LoginPageSteps;
import org.example.ui.steps.MailPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginYandexTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private LoginPageSteps loginSteps;
    private MailPageSteps mailSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        loginSteps = new LoginPageSteps(driver);
        mailSteps = new MailPageSteps(driver);
    }

    @Test
    @DisplayName("Проверка авторизации Яндекс.Почта")
    public void logInTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        loginSteps.waitForNewPageLoadingAfterPasswordSubmitting();
        mailSteps.waitForPageToBeLoaded();
        mailSteps.clickAccountAndCheckUserNameIsContained(loginName);
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта Яндекс.Почта")
    public void logOutTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        loginSteps.waitForNewPageLoadingAfterPasswordSubmitting();
        mailSteps.waitForPageToBeLoaded();
        mailSteps.clickLogOutButton();
        loginSteps.waitForPageToBeLoaded();
        loginSteps.checkPasswordInputIsEmpty();
    }

    @Test
    @DisplayName("Проверка отсутствия авторизации при использовании неправильного пароля")
    public void invalidPasswordTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit("No" + loginPass);
        loginSteps.checkWrongPasswordErrorExists();
    }

    @Test
    @DisplayName("Проверка отсутствия авторизации по несуществующему аккаунту")
    public void invalidLoginTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit("No" + loginName);
        loginSteps.checkWrongLoginNameErrorExists();
    }
}
