package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private final By resultListHeaders = By.xpath("//span[contains(@class,'OrganicTitleContentSpan')]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void checkThereIsAtLeastOneResult() {
        ensureThereIsAtLeastOneElement(resultListHeaders);
    }

    public String getFirstResultHeader() {
        return driver.findElements(resultListHeaders).get(0).getText();
    }
}
