package org.example.patterns.creational.abstractfactory.banking;

import org.example.patterns.creational.abstractfactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}
