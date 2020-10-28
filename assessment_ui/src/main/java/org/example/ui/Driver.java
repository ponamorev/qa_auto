package org.example.ui;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class Driver {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
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
                String pathToChromeDriver = webDriverProperties.getProperty(WEBDRIVER_CHROME_DRIVER);
                String pathToFirefoxDriver = webDriverProperties.getProperty(WEBDRIVER_GECKO_DRIVER);
                System.setProperty(WEBDRIVER_CHROME_DRIVER, pathToChromeDriver);
                System.setProperty(WEBDRIVER_GECKO_DRIVER, pathToFirefoxDriver);
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
        switch (browserName) {
            case FIREFOX:
                return getFirefoxDriver();
            case CHROME:
                return getChromeDriver();
            default:
                log.warn("Browser wasn't specified, start test with Chrome..");
                return getChromeDriver();
        }
    }

    private static ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.setHeadless(true);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        }
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new ChromeDriver(options);
    }

    private static FirefoxDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
            options.setHeadless(true);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        }
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        return new FirefoxDriver(options);
    }
}
