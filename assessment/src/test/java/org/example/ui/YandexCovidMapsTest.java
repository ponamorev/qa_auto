package org.example.ui;

import org.example.ui.steps.MainPageSteps;
import org.example.ui.steps.maps.CovidMapsPageSteps;
import org.example.ui.steps.maps.MapsPageSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YandexCovidMapsTest extends BaseYandexTest {
    private MainPageSteps mainSteps;
    private MapsPageSteps mapsSteps;
    private CovidMapsPageSteps covidMapsSteps;

    @BeforeEach
    public void testSetUp() {
        initWebDriver();
        driver.get(yandexMainPageUrl);

        mainSteps = new MainPageSteps(driver);
        mapsSteps = new MapsPageSteps(driver);
        covidMapsSteps = new CovidMapsPageSteps(driver);

        goToCovidMapsPage();
    }

    @Test
    @DisplayName("Сравнение двух стран по количеству заболеваний")
    public void countriesCasesComparisonTest() {
        String firstCountry = "США";
        String secondCountry = "Россия";

        covidMapsSteps.switchToGlobalCovidDistributionResults();
        covidMapsSteps.checkOneCountryHasMoreCovidCasesThanAnother(firstCountry, secondCountry);
    }

    @Test
    @DisplayName("Проверка превышения ожидаемого количества заболевших в регионе")
    public void regionCasesTest() {
        String region = "Пензенская область";
        long cases = 15000;

        covidMapsSteps.clickExpandAllResultButton();
        covidMapsSteps.checkRegionHasMoreCasesThanExpected(region, cases);
    }

    private void goToCovidMapsPage() {
        mainSteps.waitForPageToBeLoaded();
        mainSteps.clickNavigationButton("Карты");
        mainSteps.switchToNewTabAndClosePrevious(driver);
        mapsSteps.waitForPageToBeLoaded();
        mapsSteps.clickActualButton();
        mapsSteps.clickCovidMapsLink();
        covidMapsSteps.waitForPageToBeLoaded();
    }
}
