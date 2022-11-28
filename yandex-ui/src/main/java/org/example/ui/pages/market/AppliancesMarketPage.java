package org.example.ui.pages.market;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class AppliancesMarketPage extends BasePage {
    private final By fridgeButton = By.xpath("(//div[@data-tid='cb168a42']//a[contains(text(),'Холодильники')])[1]");
    private final By fridgeWidthToInput = By.id("15464317to");
    private final By firstFridgeButton = By.xpath("(//article[@data-autotest-id='product-snippet']//div[@class='_1B9w_GzQuM']/a)[1]");
    private final By searchTitle = By.xpath("//div[@data-tid='75b704b6']/h1");

    public AppliancesMarketPage(WebDriver driver) {
        super(driver);
    }

    public void clickFridgeButton() {
        getClickableElement(fridgeButton).click();
    }

    public void clearFridgeWidthToInput() {
        getClickableElement(fridgeWidthToInput).clear();
    }

    public void clickFridgeWidthToInput() {
        getClickableElement(fridgeWidthToInput).click();
    }

    public void sendFridgeWidthTo(int width) {
        getClickableElement(fridgeWidthToInput).sendKeys(String.valueOf(width));
    }

    public boolean isFirstFridgeButtonClickable() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(firstFridgeButton));
            return true;
        } catch (TimeoutException e) {
            log.error("Element {} is not clickable after 10 seconds..", firstFridgeButton);
            LogToAllure.logError("Element {} is not clickable after 10 seconds..", firstFridgeButton);
            return false;
        }
    }

    public boolean isSearchTitleContainsText(String text) {
        return new WebDriverWait(driver, 10)
                .until(driver -> getElement(searchTitle).getText().contains(text));
    }

    public String getFridgeParametersFromList(int index) {
        String nFridgeParameters = "(//article[@data-autotest-id='product-snippet']//ul/li[contains(text(),'ШхВхГ')])[%d]";
        By fridgeLocator = By.xpath(String.format(nFridgeParameters, index));
        return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(fridgeLocator))
                    .getText();
    }
}
