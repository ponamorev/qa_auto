package org.example.ui.pages.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.example.ui.LogToAllure;
import org.example.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class KinopoiskFilmPage extends BasePage {
    private final By filmName = By.xpath("//span[@data-tid='75209b22']");
    private final By filmReleaseYear = By.xpath("//div[text()='Год производства']/parent::div//a");

    public KinopoiskFilmPage(WebDriver driver) {
        super(driver);
    }

    public String getFilmName() {
        return getElement(filmName).getText();
    }

    public int getFilmReleaseYear() {
        try {
            return Integer.parseInt(getClickableElement(filmReleaseYear).getText());
        } catch (NumberFormatException e) {
            log.error("Ошибка при получении года выпуска фильма");
            LogToAllure.logError("Ошибка при получении года выпуска фильма");
            return 0;
        }
    }
}
