package org.example.sandbox.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Third extends Second {
    Third() {
        log.info("This is constructor from class Third.java");
    }
}
