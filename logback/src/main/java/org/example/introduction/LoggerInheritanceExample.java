package org.example.introduction;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerInheritanceExample {
    public static void main(String[] args) {
        // assign package logger level INFO
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org.example.introduction");
        logger.setLevel(Level.INFO);

        Logger barLogger = LoggerFactory.getLogger("org.example.introduction.LoggerInheritanceExample");

        // This request is enabled, because WARN >= INFO
        logger.warn("Low fuel level.");

        // This request is disabled, because DEBUG < INFO
        logger.debug("Starting search for nearest gas station");

        // barLogger inherits its level from parent 'logger' instance
        // This request is enabled, because INFO >= INFO
        barLogger.info("Located nearest gas station");

        // This request is disabled, because DEBUG < INFO
        barLogger.debug("Exiting gas station search");
    }
}
