package org.example.ui.pages.market;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class ElectronicsMarketPage extends BasePage {
    private final By actionCamerasButton = By.xpath("//a[contains(text(),'Экшн-камеры')]");
    private final By priceSortAscButton = By.xpath("//button[@data-autotest-id='dprice']");
    private final By priceSortDescButton = By.xpath("//button[@data-autotest-id='aprice']");

    public ElectronicsMarketPage(WebDriver driver) {
        super(driver);
    }

    public void clickActionCamerasButton() {
        getClickableElement(actionCamerasButton).click();
    }

    public void clickPriceSortAscButton() {
        getClickableElement(priceSortAscButton).click();
    }

    public void clickPriceSortDescButton() {
        getClickableElement(priceSortDescButton).click();
    }

    public BigDecimal getProductPrice(int count) {
        String productPrice = "//article[@data-autotest-id='offer-snippet'][%d]//div[@data-zone-name='price']//span/span[1]";
        String price = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(productPrice, count))))
                .getText();
        return new BigDecimal(price.replaceAll("\\s+", ""));
    }
}
