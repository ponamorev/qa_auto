package org.example.sandbox.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Second extends First {
    Second() {
        log.info("This is constructor from class Second.java");
    }
}
