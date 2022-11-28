package org.example.ui;

import io.qameta.allure.Attachment;

import java.util.Date;

public class LogToAllure {
    public static void logInfo(String message, Object... args) {
        log("INFO", message, args);
    }

    public static void logDebug(String message, Object... args) {
        log("DEBUG", message, args);
    }

    public static void logWarn(String message, Object... args) {
        log("WARN", message, args);
    }

    public static void logError(String message, Object... args) {
        log("ERROR", message, args);
    }

    @Attachment
    private static String log(String level, String message, Object... args) {
        String builder = String.format("%s %s: ", new Date(), level) +
                message.replaceAll("\\{}", "%s");
        return String.format(builder, args);
    }
}
