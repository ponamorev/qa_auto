package org.example.ui_maven.drivers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class Driver {
    private static final String chromeDriverPropName = "webdriver.chrome.driver";
    private static Properties webDriverProperties;
    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        initProperties();
        if (webDriver == null) {
            log.info("WebDriver is null, initiate new WebDriver");
            return new ChromeDriver();
        }
        return webDriver;
    }

    private static void initProperties() {
        if (webDriverProperties == null) {
            webDriverProperties = new Properties();
            try (FileInputStream inputStream = new FileInputStream("src/main/resources/driver.properties")) {
                webDriverProperties.load(inputStream);
                String pathToChromeDriver = webDriverProperties.getProperty(chromeDriverPropName);
                System.setProperty(chromeDriverPropName, pathToChromeDriver);
                log.trace("Properties with information about WebDriver was uploaded to program");
            } catch (FileNotFoundException fnfEx) {
                log.error("File with properties wasn't found by path src/main/resources/driver.properties");
                throw new RuntimeException("Check configuration for driver initialization");
            } catch (IOException ioEx) {
                log.error("There was unexpected IO error, properties for WebDriver may be not initiated");
            }
        }
    }
}
