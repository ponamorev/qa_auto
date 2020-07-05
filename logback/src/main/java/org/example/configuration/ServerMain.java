package org.example.configuration;

import ch.qos.logback.classic.util.ContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMain {
    // must be set before the first call to LoggerFactory.getLogger();
    // ContextInitializer.CONFIG_FILE_PROPERTY is set to "logback.configurationFile"
    static {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "../../../../resources/logback_debug_enabled.xml");
    }

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(ServerMain.class);
        logger.info("Entering application");
        Foo foo = new Foo();
        foo.doIt();
        logger.info("Exiting application");
    }
}
