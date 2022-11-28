package org.example.ui.pages.kinopoisk;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private final String filmInfoLocator = "(//div[contains(@class,'search_results_last')]//div[@class='info']/p/%s)[%d]";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getFilmName(int index) {
        By filmInfoName = By.xpath(String.format(filmInfoLocator, "a", index));
        return getElement(filmInfoName).getText();
    }

    public String getFilmReleaseYear(int index) {
        By filmInfoReleaseYear = By.xpath(String.format(filmInfoLocator, "span", index));
        return getElement(filmInfoReleaseYear).getText();
    }
}
