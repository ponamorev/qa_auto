package org.example.ui.bbc;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.drivers.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BbcComTest {
    private final WebDriver driver = Driver.getDriver();

    @BeforeEach
    void setUp() {
        String url = "https://www.bbc.com";

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    void test() {
        WebElement searchInput = driver.findElement(By.id("orb-search-q"));
        boolean isSearchDisplayed = searchInput.isDisplayed();
        boolean isSearchEnabled = searchInput.isEnabled();
        log.info("Is Web Element by id {} displayed? A: {}", "orb-search-q", isSearchDisplayed);
        log.info("Is Web Element by id {} enabled? A: {}", "orb-search-q", isSearchEnabled);
        searchInput.sendKeys("COVID-19");
        searchInput.submit();
        WebElement firstResultLink = driver.findElement(By.cssSelector(".css-1vg3h2e-Stack.e1y4nx260 li:first-child a"));
        log.info("Name of the first element - {}", firstResultLink.getText());
        firstResultLink.click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
