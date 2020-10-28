package org.example.ui;

import org.example.ui.drivers.Driver;
import org.example.ui.steps.LoginPageSteps;
import org.example.ui.steps.MailPageSteps;
import org.example.ui.steps.MainPageSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void logInTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        mailSteps.waitForPageToBeLoaded();
        mailSteps.clickAccountAndCheckUserNameIsContained(loginName);
    }

    @Test
    public void logOutTest() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickLoginButton();
        mainSteps.switchToNewTabAndClosePrevious(driver);
        loginSteps.waitForPageToBeLoaded();
        loginSteps.setLoginAndSubmit(loginName);
        loginSteps.setPasswordAndSubmit(loginPass);
        mailSteps.waitForPageToBeLoaded();
        mailSteps.clickLogOutButton();
        loginSteps.waitForPageToBeLoaded();
        loginSteps.checkPasswordInputIsEmpty();
    }

    @AfterEach
    public void loginTearDown() {
        try {
            Driver.closeWebDriver();
        } catch (Exception e) {
            takeScreenShotAndFail(driver, e);
        }
    }
}
