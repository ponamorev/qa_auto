package org.example.patterns.structural.composite.project;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CppDeveloper implements Developer {
    private final DeveloperLevel level;

    @Override
    public void createProject() {
        writeCode();
    }

    @Override
    public void writeCode() {
        System.out.println(level.getLevel() + " C++ developer writes C++ code...");
    }
}
