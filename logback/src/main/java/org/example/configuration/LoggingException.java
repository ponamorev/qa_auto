package org.example.configuration;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingException {
    final static Logger logger = LoggerFactory.getLogger(LoggingException.class);

    public static void main(String[] args) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.setPackagingDataEnabled(true); // - the same as 'packagingData="true"' for configuration tag in config file

        logger.info("99 is not a valid value", new Exception("99 is invalid"));
    }
}
