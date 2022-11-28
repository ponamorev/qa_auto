package org.example.ui.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Properties;

public class FirefoxWebDriver {
    static FirefoxDriver getDriver(Properties webDriverProperties) {
        FirefoxOptions options = new FirefoxOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.setHeadless(true);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        }
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new FirefoxDriver(options);
    }
}
