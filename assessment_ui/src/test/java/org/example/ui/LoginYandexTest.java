package org.example.ui;

import org.example.ui.pages.LoginPage;
import org.example.ui.pages.MailPage;
import org.example.ui.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class LoginYandexTest extends BaseYandexTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private MailPage mailPage;

    @BeforeEach
    public void testSetUp() {
        driver.get(yandexMainPageUrl);
    }

    @Test
    public void logInTest() {
        mainPage = new MainPage(driver);
        String mainPageTab = driver.getWindowHandle();
        mainPage.clickLoginButton();
        Set<String> tabs = driver.getWindowHandles();
        tabs.remove(mainPageTab);
        driver.switchTo().window(tabs.iterator().next());
        loginPage = new LoginPage(driver);
        loginPage.clickLoginNameInput();
        loginPage.loginNameInputSendKeys(loginName);
        loginPage.clickSubmitButton();
        loginPage.clickLoginPasswordInput();
        loginPage.loginPasswordInputSendKeys(loginPass);
        loginPage.clickSubmitButton();
        mailPage = new MailPage(driver);
        mailPage.clickAccountButton();
        Assertions.assertTrue(mailPage.getUserName().contains(loginName));
    }
}
