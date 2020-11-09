package org.example.ui.pages.maps;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CovidMapsPage extends BasePage {
    private final By covidSwitchGlobalView = By.xpath("//div[@class='covid-switch-view']/div[text()='Мир']");
    private final By expandAllRegionsButton = By.className("covid-table-view__expand");

    public CovidMapsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCovidSwitchGlobalView() {
        getClickableElement(covidSwitchGlobalView).click();
    }

    public boolean isCovidRegionsDistributionTableAvailable() {
        String covidRegionsDistributionTable = "//table[@class='covid-table-view__table']/tbody/tr[1]/td[1]";
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(covidRegionsDistributionTable))).isDisplayed();
    }

    public String getRegionCasesAmountFromTable(String region) {
        String countryCovidTableRowLocator = "//td[@class='covid-table-view__item-name'][text()='%s']/parent::tr/td[2]";
        By countryCasesAmount = By.xpath(String.format(countryCovidTableRowLocator, region));
        return getClickableElement(countryCasesAmount).getText();
    }

    public void clickExpandAllRegionsButton() {
        getClickableElement(expandAllRegionsButton).click();
    }
}
