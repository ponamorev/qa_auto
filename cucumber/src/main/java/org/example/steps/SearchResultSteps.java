package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import org.example.pages.SearchResultPage;
import org.testng.Assert;

public class SearchResultSteps extends BaseSteps {
    private final SearchResultPage page;

    public SearchResultSteps() {
        super();
        page = new SearchResultPage(driver);
    }

    @Then("^Result page is reached$")
    @То("^страница с результатами поиска откроется$")
    public void loadResultsPage() {
        page.waitForPageToBeLoaded();
        page.checkThereIsAtLeastOneResult();
    }

    @And("^The first result has title \"(.*)\"$")
    @И("^первым результатом будет \"(.*)\"$")
    public void checkFirstTitleIs(String title) {
        String firstTitle = page.getFirstResultHeader();
        Assert.assertEquals(firstTitle, title);
    }
}
