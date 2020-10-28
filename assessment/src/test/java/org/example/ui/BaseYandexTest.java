package org.example.ui;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.drivers.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseYandexTest {
    protected static String loginName;
    protected static String loginPass;
    protected static Properties testsProperties;
    protected static WebDriver driver;
    protected final String yandexMainPageUrl = "https://yandex.ru";

    @BeforeAll
    protected static void setUp() {
        try {
            initProperties();
            driver = Driver.getWebDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginName = testsProperties.getProperty("yandex.login.name");
            loginPass = testsProperties.getProperty("yandex.login.password");
        } catch (Exception e) {
            takeScreenShotAndFail(driver, e);
        }
    }

    @AfterAll
    protected static void tearDown() {
        try {
            Driver.closeWebDriver();
        } catch (Exception e) {
            takeScreenShotAndFail(driver, e);
        }
    }

    private static void takeScreenShotAndFail(WebDriver driver, Exception e) {
        log.error("There was an error during initialization before all tests");
        if (Objects.nonNull(driver)) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
        log.error("Error: ", e);
        Assertions.fail();
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    private static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    private static void initProperties() {
        if (Objects.isNull(testsProperties)) {
            testsProperties = new Properties();
            String propertiesPath = "src/test/resources/tests.properties";
            try (FileInputStream inputStream = new FileInputStream(propertiesPath)) {
                testsProperties.load(inputStream);
                log.trace("Successfully load properties for tests");
            } catch (FileNotFoundException fnfEx) {
                log.error("Can't find properties file {}:", propertiesPath, fnfEx);
                throw new RuntimeException("Can't find properties file " + propertiesPath);
            } catch (IOException ioEx) {
                log.error("Can't read properties from file {}", propertiesPath, ioEx);
                throw new RuntimeException("Can't read properties from file " + propertiesPath);
            }
        }
    }
}
