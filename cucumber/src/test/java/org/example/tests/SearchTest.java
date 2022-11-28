package org.example.tests;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SearchTest extends TestRunner {
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
}
