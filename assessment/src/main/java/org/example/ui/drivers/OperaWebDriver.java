package org.example.ui.drivers;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Properties;

public class OperaWebDriver {
    static OperaDriver getDriver(Properties webDriverProperties) {
        OperaOptions options = new OperaOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless");
        }
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new OperaDriver(options);
    }
}
