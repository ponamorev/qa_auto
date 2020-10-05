package org.example.ui;

import org.example.ui.pages.LoginPage;
import org.example.ui.pages.MailPage;
import org.example.ui.pages.MainPage;
import org.example.ui.steps.LoginPageSteps;
import org.example.ui.steps.MailPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class LoginYandexTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private LoginPageSteps loginSteps;
    private MailPageSteps mailSteps;

    @BeforeEach
    public void testSetUp() {
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        loginSteps = new LoginPageSteps(driver);
        mailSteps = new MailPageSteps(driver);
    }

    @Test
    public void logInTest() {
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        mailSteps.clickAccountAndCheckUserNameIsContained(loginName);
    }
}
