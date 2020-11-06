package org.example.ui.pages.market;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class ComparisonPage extends BasePage {
    private final By noProductMessage = By.className("_1uGSd1UzAC");
    private final String comparisonProducts = "//div[@class='LwwocgVx0q zvRJMhRW-w']";
    private final String comparisonProductItem = comparisonProducts + "[%d]";

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public String getComparableProductName(int count) {
        String comparisonProductLink = comparisonProductItem + "/a";
        return getClickableElement(By.xpath(String.format(comparisonProductLink, count))).getText();
    }

    public void clickDeleteComparisonProduct(int count) {
        String deleteComparisonProductButton = comparisonProductItem + "//div[@class='_3_z1ZpyV9T']";
        WebElement product = getClickableElement(By.xpath(String.format(deleteComparisonProductButton, count)));
        new Actions(driver)
                .moveToElement(product)
                .build()
                .perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(product))
                .click();
    }

    public boolean isComparisonProductsListStale() {
        boolean result;
        try {
            result = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(
                            By.xpath(comparisonProducts))));
        } catch (NoSuchElementException e) {
            LogToAllure.logInfo(log, "Element {} was disappeared from DOM", comparisonProducts);
            result = true;
        }
        return result;
    }

    public String getNoProductMessageText() {
        return getElement(noProductMessage).getText();
    }
}
