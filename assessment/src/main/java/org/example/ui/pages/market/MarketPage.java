package org.example.ui.pages.market;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class MarketPage extends BasePage {
    private final By searchInput = By.id("header-search");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By compareButton = By.className("_3oDLePObQ1");
    private final By electronicsTabButton = By.xpath("//span[contains(text(),'Электроника')]/parent::a");
    private final String nProductItem = "//div[contains(@class,'_2Qo3ODl0by')]/child::article[%d]";

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public void clearSearchInput() {
        getClickableElement(searchInput).clear();
    }

    public void clickSearchInput() {
        getClickableElement(searchInput).click();
    }

    public void sendSearchString(String searchProduct) {
        getClickableElement(searchInput).sendKeys(searchProduct);
    }

    public void clickSubmitSearchButton() {
        getClickableElement(submitButton).click();
    }

    public String getProductName(int count) {
        String productItemTitle = nProductItem + "//a[@title]";
        return getClickableElement(By.xpath(String.format(productItemTitle, count))).getAttribute("title");
    }

    public void clickAddProductToComparisonButton(int count) {
        String productItemComparisonButton = nProductItem + "//div[@class='_1CXljk9rtd']";
        getClickableElement(By.xpath(String.format(productItemComparisonButton, count))).click();
    }

    public void clickCompareButton() {
        try {
            clickProbablyStaleElement(compareButton);
        } catch (ElementNotInteractableException e) {
            LogToAllure.logWarn(log, "Can't click element {} because of: {}", compareButton, e.getMessage());
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(compareButton))
                    .click();
        }
    }

    public void clickElectronicsTabButton() {
        getClickableElement(electronicsTabButton).click();
    }
}
