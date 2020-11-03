package org.example.patterns.structural.facade;

import lombok.Getter;

public class BugTracker {
    @Getter
    private boolean activeSprint;

    public void startSprint() {
        System.out.println("Sprint is active...");
        activeSprint = true;
    }

    public void finishSprint() {
        System.out.println("Sprint is not active...");
        activeSprint = false;
    }
}
