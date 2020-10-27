package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends BasePage {
    private final By accountButton = By.cssSelector(".legouser_fetch-accounts_yes");
    private final By userName = By.cssSelector("div.legouser__menu-header .user-account__name");

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountButton() {
        getClickableElement(accountButton).click();
    }

    public String getUserName() {
        return getElement(userName).getText();
    }
}
