package org.example.ui.steps.maps;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;
import org.example.ui.LogToAllure;
import org.example.ui.pages.maps.CovidMapsPage;
import org.example.ui.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CovidMapsPageSteps extends BaseSteps {
    private final CovidMapsPage page;

    public CovidMapsPageSteps(WebDriver driver) {
        page = new CovidMapsPage(driver);
    }

    @Override
    @Step("Ожидание загрузки страницы с картой распространения коронавируса")
    public void waitForPageToBeLoaded() {
        page.waitForPageToBeLoaded();
    }

    @Step("Переключить таблицу выявленных случаев на 'Мир'")
    public void switchToGlobalCovidDistributionResults() {
        page.clickCovidSwitchGlobalView();
    }

    @Step("Проверить, что у страны '{firstCountry}' больше заболевших, чем у '{secondCountry}'")
    public void checkOneCountryHasMoreCovidCasesThanAnother(String firstCountry, String secondCountry) {
        Awaitility.await().atMost(10, TimeUnit.SECONDS)
                .until(page::isCovidRegionsDistributionTableAvailable);

        long firstCountryCases = getCasesByRegion(firstCountry);
        long secondCountryCases = getCasesByRegion(secondCountry);
        boolean condition = firstCountryCases != 0
                && secondCountryCases != 0
                && firstCountryCases > secondCountryCases;
        Assertions.assertTrue(condition, String.format("Число заболевших в %s меньше, чем в %s", firstCountry, secondCountry));
    }

    @Step("Нажать кнопку 'Показать все'")
    public void clickExpandAllResultButton() {
        page.clickExpandAllRegionsButton();
    }

    @Step("Проверить, что для региона '{region}' число заболевших больше, чем {cases}")
    public void checkRegionHasMoreCasesThanExpected(String region, long cases) {
        Assertions.assertTrue(getCasesByRegion(region) > cases,
                String.format("Для региона %s число заболеваний не превышает %d", region, cases));
    }

    private long getCasesByRegion(String region) {
        String casesString = page.getRegionCasesAmountFromTable(region);
        casesString = casesString.replaceAll("\\s+", "");
        try {
            return Long.parseLong(casesString);
        } catch (NumberFormatException e) {
            log.error("Проблема при конвертации полученного значения из строки в long формат, исходная строка: {}", casesString);
            LogToAllure.logError("Проблема при конвертации полученного значения из строки в long формат, исходная строка: {}", casesString);
            Assertions.fail("Проблема при конвертации полученного значения из строки в long формат, исходная строка: " + casesString);
            // unreachable statement, but it was necessary for IDE
            return 0;
        }
    }
}
