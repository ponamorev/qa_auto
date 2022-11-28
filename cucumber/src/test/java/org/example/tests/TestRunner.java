package org.example.tests;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.example.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"org.example.steps"}
)
public class TestRunner {
    private TestNGCucumberRunner runner;
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUpCucumber() {
        runner = new TestNGCucumberRunner(this.getClass());
        driver = Driver.getDriver();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        runner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return runner.provideScenarios();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() {
        driver.quit();
        runner.finish();
    }
}
