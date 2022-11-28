package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.pages.SearchResultPage;
import org.testng.Assert;

public class SearchResultSteps extends BaseSteps {
    private final SearchResultPage page;

    public SearchResultSteps() {
        super();
        page = new SearchResultPage(driver);
    }

    @Then("^Result page is reached$")
    public void result_page_is_reached() {
        page.waitForPageToBeLoaded();
        page.checkThereIsAtLeastOneResult();
        String firstTitle = page.getFirstResultHeader();
        Assert.assertEquals(firstTitle, "Java | Oracle");
    }
}
