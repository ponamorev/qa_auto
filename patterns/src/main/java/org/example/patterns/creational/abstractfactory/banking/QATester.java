package org.example.patterns.creational.abstractfactory.banking;

import org.example.patterns.creational.abstractfactory.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QA tester tests banking code...");
    }
}
