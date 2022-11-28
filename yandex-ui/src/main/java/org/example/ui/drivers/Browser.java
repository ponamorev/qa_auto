package org.example.ui.drivers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Browser {
    CHROME("chrome", "webdriver.chrome.driver"),
    FIREFOX("firefox", "webdriver.gecko.driver"),
    OPERA("opera", "webdriver.opera.driver");

    private final String browserName;
    private final String webDriverPropName;
}
