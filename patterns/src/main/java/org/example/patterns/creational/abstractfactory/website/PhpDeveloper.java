package org.example.patterns.creational.abstractfactory.website;

import org.example.patterns.creational.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code...");
    }
}
