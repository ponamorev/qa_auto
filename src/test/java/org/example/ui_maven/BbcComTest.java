package org.example.ui_maven;

import lombok.extern.slf4j.Slf4j;
import org.example.ui_maven.drivers.Driver;
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
        searchInput.sendKeys("Strange things");
        searchInput.submit();
        WebElement firstResultLink = driver.findElement(By.cssSelector(".search-results li:first-child div a"));
        firstResultLink.click();
        log.info("Name of the first element - {}", firstResultLink.getText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
