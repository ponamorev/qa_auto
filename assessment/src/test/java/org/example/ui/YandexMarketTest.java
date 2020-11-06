package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.market.ComparisonPageSteps;
import org.example.ui.steps.market.MarketPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YandexMarketTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private MarketPageSteps marketSteps;
    private ComparisonPageSteps comparisonSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        marketSteps = new MarketPageSteps(driver);
        comparisonSteps = new ComparisonPageSteps(driver);
    }

    @Test
    @DisplayName(value = "Проверка сравнения добавленных товаров")
    public void productsComparisonTest() {
        String productName = "Note 8";

        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickNavigationButton("Маркет");
        mainSteps.switchToNewTabAndClosePrevious(driver);
        marketSteps.waitForPageToBeLoaded();
        marketSteps.setProductNameAndSearch(productName);
        marketSteps.waitForPageToBeLoaded();
        String firstProductName = marketSteps.getFirstProductName();
        String secondProductName = marketSteps.getSecondProductName();
        marketSteps.addProductToComparison(1);
        marketSteps.addProductToComparison(2);
        marketSteps.clickCompareButton();
        comparisonSteps.waitForPageToBeLoaded();
        comparisonSteps.checkComparableProductName(1, firstProductName);
        comparisonSteps.checkComparableProductName(2, secondProductName);
    }
}
