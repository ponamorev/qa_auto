package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class SearchSteps extends BaseSteps {
    private final SearchPage page;

    public SearchSteps(WebDriver driver) {
        super(driver);
        page = new SearchPage(driver);
    }

    @Given("^User navigates to \"(.*)\"$")
    public void user_navigates_to_website(String website) {
        driver.get(website);
        driver.manage().window().maximize();
        page.waitForPageToBeLoaded();
    }

    @When("^User puts \"(.*)\" to an input$")
    public void user_puts_text_to_an_input(String text) {
        page.checkSearchInputIsClickable();
        page.clearSearchInput();
        page.clickSearchInput();
        page.sendKeysToSearchInput(text);
    }

    @And("^User clicks Search Button$")
    public void user_clicks_search_button() {
        page.checkSearchButtonIsClickable();
        page.clickSearchButton();
    }
}
