package org.example.patterns.structural.composite.project;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavaDeveloper implements Developer {
    private final DeveloperLevel level;

    @Override
    public void createProject() {
        writeCode();
    }

    @Override
    public void writeCode() {
        System.out.println(level.getLevel() + " Java developer writes Java code...");
    }
}
