package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends BasePage {
    private final By accountButton = By.cssSelector(".user-account.user-account_left-name");
    private final By userName = By.cssSelector(".legouser__menu-header span.user-account__name");

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }
}
