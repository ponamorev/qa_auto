package org.example.ui_maven.other;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDebugClass {
    public static void main(String[] args) {
        log.debug("Debug log message");
        log.info("Info log message");
        log.error("Error log message");
    }
}
