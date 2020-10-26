package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By logNameInput = By.id("passp-field-login");
    private final By logPassInput = By.xpath("//*[@id=\"passp-field-passwd\"]");
    private final By submitButton = By.cssSelector(".Button2_type_submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginNameInput() {
        driver.findElement(logNameInput).click();
    }

    public void loginNameInputSendKeys(String loginName) {
        driver.findElement(logNameInput).sendKeys(loginName);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void clickLoginPasswordInput() {
        driver.findElement(logPassInput).click();
    }

    public void loginPasswordInputSendKeys(String loginPass) {
        driver.findElement(logPassInput).sendKeys(loginPass);
    }
}
