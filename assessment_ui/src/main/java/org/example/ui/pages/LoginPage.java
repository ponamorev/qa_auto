package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private final By logNameInput = By.id("passp-field-login");
    private final By logPassInput = By.id("passp-field-passwd");
    private final By submitButton = By.cssSelector(".Button2_type_submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginNameInput() {
        getClickableElement(logNameInput).click();
    }

    public void loginNameInputSendKeys(String loginName) {
        getClickableElement(logNameInput).sendKeys(loginName);
    }

    public void clickSubmitButton() {
        getClickableElement(submitButton).click();
    }

    public boolean isSubmitButtonStale() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.stalenessOf(driver.findElement(submitButton)));
    }

    public void clickLoginPasswordInput() {
        getClickableElement(logPassInput).click();
    }

    public void loginPasswordInputSendKeys(String loginPass) {
        getClickableElement(logPassInput).sendKeys(loginPass);
    }
}
