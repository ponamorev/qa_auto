package org.example.ui.pages.search;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private final By firstResultLink = By.xpath("//li[1]//a[contains(@class,'link_theme_outer')]");
    private final By advancedSearchSettingsButton = By.className("input__settings");
    private final By submitAdvancedSearchSettingsButton = By.xpath("//button[contains(@class,'advanced-search__submit-link')]");
    private final By entityHeaderTitle = By.xpath("//div[@class='entity-search__header']/div[1]");
    private final By entityHeaderSubtitle = By.xpath("//div[@class='entity-search__header']/div[2]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultLinkAddress() {
        return getClickableElement(firstResultLink).getAttribute("href");
    }

    public void clickAdvancedSearchSettingsButton() {
        getClickableElement(advancedSearchSettingsButton).click();
    }

    public void chooseAdvancedSearchCheckBox(String name) {
        String checkBoxLocator = "//span[text()='" + name + "']/preceding-sibling::input";
        getClickableElement(By.xpath(checkBoxLocator)).click();
    }

    public void clickSubmitAdvancedSearchSettingsButton() {
        getClickableElement(submitAdvancedSearchSettingsButton).click();
    }

    public String getEntityHeaderTitle() {
        return getElement(entityHeaderTitle).getText();
    }

    public String getEntityHeaderSubtitle() {
        return getElement(entityHeaderSubtitle).getText();
    }
}
