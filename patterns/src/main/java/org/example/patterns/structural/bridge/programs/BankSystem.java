package org.example.patterns.structural.bridge.programs;

import org.example.patterns.structural.bridge.developers.Developer;

public class BankSystem extends Program {
    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank System development in progress...");
        developer.writeCode();
    }
}
