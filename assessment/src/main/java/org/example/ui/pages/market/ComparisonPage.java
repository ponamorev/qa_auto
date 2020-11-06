package org.example.ui.pages.market;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparisonPage extends BasePage {
    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public String getComparableProductName(int count) {
        String comparisonProductLink = "//div[@class='LwwocgVx0q zvRJMhRW-w'][%d]/a";
        return getClickableElement(By.xpath(String.format(comparisonProductLink, count))).getText();
    }
}
