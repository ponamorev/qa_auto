package org.example.ui.steps;

import io.qameta.allure.Step;
import org.example.ui.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps extends BaseSteps {
    private final MainPage page;

    public MainPageSteps(WebDriver driver) {
        page = new MainPage(driver);
    }

    @Step(value = "Нажать кнопку входа в аккаунт")
    public void clickLoginButton() {
        page.clickLoginButton();
    }
}
