package org.example.patterns.structural.bridge.developers;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes C++ code...");
    }
}
