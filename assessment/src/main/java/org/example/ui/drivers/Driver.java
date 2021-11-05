package org.example.ui.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static org.example.ui.drivers.Browser.CHROME;
import static org.example.ui.drivers.Browser.FIREFOX;
import static org.example.ui.drivers.Browser.OPERA;

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
                log.debug("Properties with information about WebDriver was uploaded to program");
            } catch (FileNotFoundException fnfEx) {
                log.error("File with properties wasn't found by path src/main/resources/driver.properties", fnfEx);
                throw new RuntimeException("Check configuration for driver initialization");
            } catch (IOException ioEx) {
                log.error("There was unexpected IO error, properties for WebDriver may be not initiated", ioEx);
            }
        }
    }

    private static WebDriver getDriver() {
        String browserName = webDriverProperties.getProperty("browser.name").toUpperCase();
        Browser browser = Browser.valueOf(browserName);
        switch (browser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return FirefoxWebDriver.getDriver(webDriverProperties);
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return ChromeWebDriver.getDriver(webDriverProperties);
            case OPERA:
                WebDriverManager.operadriver().setup();
                return OperaWebDriver.getDriver(webDriverProperties);
            default:
                log.warn("Browser wasn't specified, start test with Chrome..");
                WebDriverManager.chromedriver().setup();
                return ChromeWebDriver.getDriver(webDriverProperties);
        }
    }
}
