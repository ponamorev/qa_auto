package org.example.patterns.structural.facade;

public class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker) {
        String action = bugTracker.isActiveSprint()
                ? "Developer is solving problems..."
                : "Developer is reading Habr...";
        System.out.println(action);
    }
}
