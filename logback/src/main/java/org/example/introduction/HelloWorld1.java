package org.example.introduction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld1 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("org.example.introduction.HelloWorld1");
        logger.debug("Hello world.");
    }
}
