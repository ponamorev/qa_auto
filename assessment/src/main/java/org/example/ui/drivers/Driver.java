package org.example.ui.drivers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static org.example.ui.drivers.Browser.OPERA;
import static org.example.ui.drivers.Browser.CHROME;
import static org.example.ui.drivers.Browser.FIREFOX;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class Driver {
    private static Properties webDriverProperties;
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        initProperties();
        if (webDriver == null) {
            log.info("WebDriver is null, initiate new WebDriver");
            webDriver = getDriver();
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        log.info("Close driver and browser");
        if (Objects.nonNull(webDriver)) {
            log.info("Driver is not null - call quit() method..");
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void initProperties() {
        if (Objects.isNull(webDriverProperties)) {
            webDriverProperties = new Properties();
            try (FileInputStream inputStream = new FileInputStream("src/main/resources/driver.properties")) {
                webDriverProperties.load(inputStream);
                String pathToChromeDriver = webDriverProperties.getProperty(CHROME.getWebDriverPropName());
                String pathToFirefoxDriver = webDriverProperties.getProperty(FIREFOX.getWebDriverPropName());
                String pathToOperaDriver = webDriverProperties.getProperty(OPERA.getWebDriverPropName());
                System.setProperty(CHROME.getWebDriverPropName(), pathToChromeDriver);
                System.setProperty(FIREFOX.getWebDriverPropName(), pathToFirefoxDriver);
                System.setProperty(OPERA.getWebDriverPropName(), pathToOperaDriver);
                log.trace("Properties with information about WebDriver was uploaded to program");
            } catch (FileNotFoundException fnfEx) {
                log.error("File with properties wasn't found by path src/main/resources/driver.properties", fnfEx);
                throw new RuntimeException("Check configuration for driver initialization");
            } catch (IOException ioEx) {
                log.error("There was unexpected IO error, properties for WebDriver may be not initiated", ioEx);
            }
        }
    }

    private static WebDriver getDriver() {
        String browserName = webDriverProperties.getProperty("browser.name");
        Browser browser = Browser.valueOf(browserName);
        switch (browser) {
            case FIREFOX:
                return FirefoxWebDriver.getDriver(webDriverProperties);
            case CHROME:
                return ChromeWebDriver.getDriver(webDriverProperties);
            case OPERA:
                return OperaWebDriver.getDriver(webDriverProperties);
            default:
                log.warn("Browser wasn't specified, start test with Chrome..");
                return ChromeWebDriver.getDriver(webDriverProperties);
        }
    }
}
