package org.example.ui.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Properties;

public class ChromeWebDriver {
    static ChromeDriver getDriver(Properties webDriverProperties) {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.setHeadless(true);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        }
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new ChromeDriver(options);
    }
}
