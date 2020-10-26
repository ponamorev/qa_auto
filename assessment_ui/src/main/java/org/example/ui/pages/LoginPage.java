package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By logNameInput = By.id("passp-field-login");
    private final By logPassInput = By.id("passp-field-passwd");
    private final By submitButton = By.cssSelector(".Button2_type_submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginNameInput() {
        getElement(logNameInput, true).click();
    }

    public void loginNameInputSendKeys(String loginName) {
        getElement(logNameInput, true).sendKeys(loginName);
    }

    public void clickSubmitButton() {
        getElement(submitButton, true).click();
    }

    public void clickLoginPasswordInput() {
        getElement(logPassInput, true).click();
    }

    public void loginPasswordInputSendKeys(String loginPass) {
        getElement(logPassInput, true).sendKeys(loginPass);
    }
}
