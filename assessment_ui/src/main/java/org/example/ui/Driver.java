package org.example.ui;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class Driver {
    private static final String chromeDriverPropName = "webdriver.chrome.driver";
    private static Properties webDriverProperties;
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        initProperties();
        if (webDriver == null) {
            log.info("WebDriver is null, initiate new WebDriver");
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(webDriverProperties.getProperty("headless.mode"))) {
                options.setHeadless(true);
                options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            }
            webDriver = new ChromeDriver(options);
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
                String pathToChromeDriver = webDriverProperties.getProperty(chromeDriverPropName);
                System.setProperty(chromeDriverPropName, pathToChromeDriver);
                log.trace("Properties with information about WebDriver was uploaded to program");
            } catch (FileNotFoundException fnfEx) {
                log.error("File with properties wasn't found by path src/main/resources/driver.properties", fnfEx);
                throw new RuntimeException("Check configuration for driver initialization");
            } catch (IOException ioEx) {
                log.error("There was unexpected IO error, properties for WebDriver may be not initiated", ioEx);
            }
        }
    }
}
