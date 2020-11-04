package org.example.ui.drivers;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Properties;

public class OperaWebDriver {
    static OperaDriver getDriver(Properties webDriverProperties) {
        OperaOptions options = new OperaOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-dev-shm-usage");
        }
        options.addArguments("--remote-debugging-port=9222");
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new OperaDriver(options);
    }
}
