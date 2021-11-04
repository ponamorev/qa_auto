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
//                String pathToChromeDriver = webDriverProperties.getProperty(CHROME.getWebDriverPropName());
//                String pathToFirefoxDriver = webDriverProperties.getProperty(FIREFOX.getWebDriverPropName());
//                String pathToOperaDriver = webDriverProperties.getProperty(OPERA.getWebDriverPropName());
//                System.setProperty(CHROME.getWebDriverPropName(), pathToChromeDriver);
//                System.setProperty(FIREFOX.getWebDriverPropName(), pathToFirefoxDriver);
//                System.setProperty(OPERA.getWebDriverPropName(), pathToOperaDriver);
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
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
                    firefoxOptions.setHeadless(true);
                    firefoxOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                }
                firefoxOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                return new FirefoxDriver(firefoxOptions);
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                }
                chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                return new ChromeDriver(chromeOptions);
            case OPERA:
                WebDriverManager.operadriver().setup();
                OperaOptions operaOptions = new OperaOptions();
                if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
                    operaOptions.addArguments("--headless");
                    operaOptions.addArguments("--disable-dev-shm-usage");
                }
                operaOptions.addArguments("--remote-debugging-port=9222");
                operaOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                return new OperaDriver(operaOptions);
            default:
                log.warn("Browser wasn't specified, start test with Chrome..");
                WebDriverManager.chromedriver().setup();
                ChromeOptions defaultOptions = new ChromeOptions();
                if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
                    defaultOptions.setHeadless(true);
                    defaultOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                }
                defaultOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                return new ChromeDriver(defaultOptions);
        }
    }
}
