package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By loginButton = By.cssSelector(".button.desk-notif-card__login-enter-expanded");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        getClickableElement(loginButton).click();
    }
}
