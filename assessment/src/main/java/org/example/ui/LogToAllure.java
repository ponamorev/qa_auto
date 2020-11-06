package org.example.ui;

import io.qameta.allure.Allure;
import org.slf4j.Logger;

import java.util.Date;

public class LogToAllure {
    public static void logInfo(Logger log, String message, Object... args) {
        log.info(message, args);
        log("INFO", message, args);
    }

    public static void logDebug(Logger log, String message, Object... args) {
        log.debug(message, args);
        log("DEBUG", message, args);
    }

    public static void logWarn(Logger log, String message, Object... args) {
        log.warn(message, args);
        log("WARN", message, args);
    }

    public static void logError(Logger log, String message, Object... args) {
        log.error(message, args);
        log("ERROR", message, args);
    }

    private static void log(String level, String message, Object... args) {
        String builder = String.format("%s %s: ", new Date(), level) +
                message.replaceAll("\\{}", "%s");
        String resultMessage = String.format(builder, args);
        Allure.addAttachment("LOG", resultMessage);
    }
}
