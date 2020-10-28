package org.example.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

@Slf4j
public class MailPage extends BasePage {
    private final By accountButton = By.cssSelector(".legouser_fetch-accounts_yes");
    private final By userName = By.cssSelector("div.legouser__menu-header .user-account__name");
    private final By logoutButton = By.cssSelector(".legouser__menu-item_action_exit");

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountButton() {
        try {
            getClickableElement(accountButton).click();
        } catch (StaleElementReferenceException e) {
            log.warn("Element is absent in DOM, try to find it again..");
            waitForPageToBeLoaded();
            getClickableElement(accountButton).click();
        }
    }

    public String getUserName() {
        return getElement(userName).getText();
    }

    public void clickLogoutButton() {
        getClickableElement(logoutButton).click();
    }
}
