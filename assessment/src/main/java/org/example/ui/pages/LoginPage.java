package org.example.ui.pages;

import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final By logNameInput = By.id("passp-field-login");
    private final By logPassInput = By.id("passp-field-passwd");
    private final By submitButton = By.cssSelector(".Button2_type_submit");
    private final By confirmLaterButton = By.xpath("//div[@data-t='phone_actual_skip']/button");
    private final By errorMessageText = By.cssSelector(".Textinput-Hint_state_error");

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
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.stalenessOf(driver.findElement(submitButton)));
    }

    public void clickLoginPasswordInput() {
        getClickableElement(logPassInput).click();
    }

    public boolean isConfirmLaterButtonDisplayed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(confirmLaterButton)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickConfirmLaterButton() {
        getClickableElement(confirmLaterButton).click();
    }

    public void loginPasswordInputSendKeys(String loginPass) {
        getClickableElement(logPassInput).sendKeys(loginPass);
    }

    public boolean isPasswordInputEmpty() {
        return Strings.isNullOrEmpty(getClickableElement(logPassInput).getText());
    }

    public String getErrorMessageText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> !Strings.isNullOrEmpty(driver.findElement(errorMessageText).getText()));
        return getElement(errorMessageText).getText();
    }
}
