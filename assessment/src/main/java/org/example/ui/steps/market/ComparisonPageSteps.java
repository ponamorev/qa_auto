package org.example.ui.steps.market;

import io.qameta.allure.Step;
import org.example.ui.pages.market.ComparisonPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ComparisonPageSteps extends BaseSteps {
    private final ComparisonPage page;

    public ComparisonPageSteps(WebDriver driver) {
        page = new ComparisonPage(driver);
    }

    @Override
    @Step(value = "Ожидание загрузки страницы с результатами сравнения товаров")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step(value = "Проверить, что {count}-й элемент из сравнения имеет название '{expectedProductName}'")
    public void checkComparableProductName(int count, String expectedProductName) {
        String actualProductName = page.getComparableProductName(count);
        Assertions.assertEquals(expectedProductName, actualProductName,
                "Название продукта не совпадает с ожидаемым");
    }
}
