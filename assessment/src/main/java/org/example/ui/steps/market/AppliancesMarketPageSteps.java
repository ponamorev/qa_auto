package org.example.ui.steps.market;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.market.AppliancesMarketPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AppliancesMarketPageSteps extends BaseSteps {
    private final AppliancesMarketPage page;

    public AppliancesMarketPageSteps(WebDriver driver) {
        page = new AppliancesMarketPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с бытовой техникой на Яндекс.Маркет")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Нажать кнопку 'Холодильники'")
    public void clickFridgeButton() {
        page.clickFridgeButton();
    }

    @Step("Ввести ограничение по ширине в {width} см")
    public void setWidthForFridge(int width) {
        page.clearFridgeWidthToInput();
        page.clickFridgeWidthToInput();
        page.sendFridgeWidthTo(width);
        page.waitForPageToBeLoaded();
    }

    @Step("Проверить, что в первых 5 результатах поиска ширина холодильника меньше или равна {width}")
    public void checkResultFridgesHaveWidthLessOrEqualTo(WebDriver driver, int width) {
        if (page.isFirstFridgeButtonClickable() &&
                page.isSearchTitleContainsText("до " + width + " см")) {
            List<String> results = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                results.add(page.getFridgeParametersFromList(i));
                log.debug("Fridge {} - {}", i, results.get(i - 1));
                LogToAllure.logDebug("Fridge {} - {}", i, results.get(i - 1));
            }

            results = results.stream()
                    .map(p -> p.replaceAll("\\W+:\\s", ""))
                    .map(p -> p.replaceAll("\\W.*", ""))
                    .collect(Collectors.toList());
            List<Float> resultWidths = new ArrayList<>();
            try {
                resultWidths = results.stream()
                        .map(Float::parseFloat)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                log.error("Ошибка во время конвертации ширины холодильника: {}", e.getMessage());
                LogToAllure.logError("Ошибка во время конвертации ширины холодильника: {}", e.getMessage());
                saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
            resultWidths = resultWidths.stream()
                    .filter(w -> w <= width)
                    .collect(Collectors.toList());
            Assertions.assertEquals(5, resultWidths.size(),
                    String.format("Выбраны холодильники с шириной больше %d", width));
        } else {
            Assertions.fail("Не прогружается список холодильников");
        }
    }
}
