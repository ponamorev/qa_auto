package org.example.patterns.structural.composite.project;

public interface Developer {
    default void add(Developer developer) {
        throw new UnsupportedOperationException();
    }

    default void createProject() {
        throw new UnsupportedOperationException();
    }

    default void writeCode() {
        throw new UnsupportedOperationException();
    }
}
