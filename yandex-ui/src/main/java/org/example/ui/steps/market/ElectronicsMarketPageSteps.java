package org.example.ui.steps.market;

import io.qameta.allure.Step;
import org.example.ui.pages.market.ElectronicsMarketPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ElectronicsMarketPageSteps extends BaseSteps {
    private final ElectronicsMarketPage page;

    public ElectronicsMarketPageSteps(WebDriver driver) {
        page = new ElectronicsMarketPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с электроникой на Яндекс.Маркет")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Перейти к экшн-камерам")
    public void goToActionCameras() {
        page.clickActionCamerasButton();
        waitForPageToBeLoaded();
        page.clickActionCamerasButton();
        waitForPageToBeLoaded();
    }

    @Step("Отсортировать список товаров по убыванию цены")
    public void sortProductsByPriceDesc() {
        page.clickPriceSortAscButton();
        waitForPageToBeLoaded();
        page.clickPriceSortDescButton();
        waitForPageToBeLoaded();
    }

    @Step("Проверить первые 5 продуктов на предмет убывания цены")
    public void checkTopFiveProductsForPriceDecreasing() {
        BigDecimal firstPrice = page.getProductPrice(1);
        BigDecimal secondPrice = page.getProductPrice(2);
        BigDecimal thirdPrice = page.getProductPrice(3);
        BigDecimal fourthPrice = page.getProductPrice(4);
        BigDecimal fifthPrice = page.getProductPrice(5);

        boolean comparison = firstPrice.compareTo(secondPrice) > 0 &&
                secondPrice.compareTo(thirdPrice) > 0 &&
                thirdPrice.compareTo(fourthPrice) > 0 &&
                fourthPrice.compareTo(fifthPrice) > 0;
        Assertions.assertTrue(comparison, "Цены на товар отсортированы не по убыванию");
    }
}
