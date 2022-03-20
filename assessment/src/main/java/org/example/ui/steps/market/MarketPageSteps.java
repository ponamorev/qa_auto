package org.example.ui.steps.market;

import io.qameta.allure.Step;
import org.example.ui.pages.market.MarketPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MarketPageSteps extends BaseSteps {
    private final MarketPage page;

    public MarketPageSteps(WebDriver driver) {
        page = new MarketPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы Яндекс.Маркет")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Override
    @Step("Проверить, что страница с Яндекс.Маркет была загружена")
    public void checkPageHasBeenLoaded() {
        String expectedPageTitle = "Яндекс.Маркет — покупки с быстрой доставкой";
        Assertions.assertEquals(expectedPageTitle, page.getPageTitle(),
                "Заголовок страницы Яндекс.Маркет не совпадает с ожидаемым");
    }

    @Step("Ввести в строку поиска название '{product}' и нажать кнопку 'Найти'")
    public void setProductNameAndSearch(String product) {
        page.clearSearchInput();
        page.clickSearchInput();
        page.sendSearchString(product);
        page.clickSubmitSearchButton();
    }

    @Step("Получить название первого товара")
    public String getFirstProductName() {
        return page.getProductName(1);
    }

    @Step("Получить название второго товара")
    public String getSecondProductName() {
        return page.getProductName(2);
    }

    @Step("Добавить {count}-й товар в сравнение")
    public void addProductToComparison(int count) {
        page.clickAddProductToComparisonButton(count);
    }

    @Step("Нажать кнопку 'Сравнить'")
    public void clickCompareButton() {
        page.clickCompareButton();
    }

    @Step("Нажать кнопку вкладки 'Электроника'")
    public void clickElectronicsTabButton() {
        page.clickElectronicsTabButton();
    }

    @Step("Нажать кнопку вкладки 'Бытовая техника'")
    public void clickAppliancesTabButton() {
        page.clickAppliancesTabButton();
    }
}
