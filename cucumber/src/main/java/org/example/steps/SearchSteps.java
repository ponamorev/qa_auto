package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import org.example.pages.SearchPage;

public class SearchSteps extends BaseSteps {
    private final SearchPage page;

    public SearchSteps() {
        super();
        page = new SearchPage(driver);
    }

    @Given("^User navigates to \"(.*)\"$")
    @Если("^пользователь переходит на страницу \"(.*)\"$")
    public void goToPage(String url) {
        driver.get(url);
        page.waitForPageToBeLoaded();
    }

    @When("^User puts \"(.*)\" to an input$")
    @И("^вводит в строку поиска \"(.*)\"$")
    public void putSearchText(String text) {
        page.checkSearchInputIsClickable();
        page.clearSearchInput();
        page.clickSearchInput();
        page.sendKeysToSearchInput(text);
    }

    @And("^User clicks Search Button$")
    @И("^нажимает кнопку поиска$")
    public void clickSearchButton() {
        page.checkSearchButtonIsClickable();
        page.clickSearchButton();
    }
}
