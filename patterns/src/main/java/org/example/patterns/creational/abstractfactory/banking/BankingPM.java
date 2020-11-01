package org.example.patterns.creational.abstractfactory.banking;

import org.example.patterns.creational.abstractfactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
