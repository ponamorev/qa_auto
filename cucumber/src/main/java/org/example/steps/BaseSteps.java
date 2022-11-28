package org.example.steps;

import org.example.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps() {
        this.driver = Driver.getDriver();
    }
}
