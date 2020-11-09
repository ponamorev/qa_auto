package org.example.ui.pages.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilmListPage extends BasePage {
    private final By top250FilmLink = By.xpath("//div[@class='film-lists__content']//span[contains(text(),'250')]//ancestor::a");
    private final By firstFilmResultTitles = By.xpath("//div[@class='desktop-rating-selection-film-item'][1]//p");

    public FilmListPage(WebDriver driver) {
        super(driver);
    }

    public void clickTop250FilmsLink() {
        getClickableElement(top250FilmLink).click();
    }

    public List<String> getFirstFilmResultTitles() {
        List<WebElement> titles = driver.findElements(firstFilmResultTitles);
        if (!titles.isEmpty()) {
            return titles.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
        } else {
            log.error("Отсутствуют заголовки для первого фильма из списка");
            LogToAllure.logError("Отсутствуют заголовки для первого фильма из списка");
        }
        return Collections.emptyList();
    }
}
