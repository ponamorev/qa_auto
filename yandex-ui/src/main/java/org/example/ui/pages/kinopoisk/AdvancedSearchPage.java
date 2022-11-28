package org.example.ui.pages.kinopoisk;

import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdvancedSearchPage extends BasePage {
    private final By countrySelect = By.id("country");
    private final By genresWindow = By.cssSelector(".el_6.__genreSB__");
    private final By tillYearDropDown = By.cssSelector(".__yearSB2__");
    private final By submitFilmSearchButton = By.cssSelector(".el_18.submit");

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickCountrySelect() {
        getClickableElement(countrySelect).click();
    }

    public void selectCountry(String country) {
        String countryOptionLocator = "(//select[@id='country']/option[contains(text(),'%s')])[1]";
        getClickableElement(By.xpath(String.format(countryOptionLocator, country))).click();
    }

    public void selectGenres(String... genres) {
        Select select = new Select(getElement(genresWindow));
        for (String genre : genres) {
            select.selectByVisibleText(genre);
        }
    }

    public void selectTillYear(int year) {
        Select select = new Select(getElement(tillYearDropDown));
        select.selectByValue(String.valueOf(year));
    }

    public void clickSubmitFilmSearchButton() {
        getClickableElement(submitFilmSearchButton).click();
    }
}
