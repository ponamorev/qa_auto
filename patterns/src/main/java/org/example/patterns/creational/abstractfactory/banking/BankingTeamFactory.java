package org.example.patterns.creational.abstractfactory.banking;

import org.example.patterns.creational.abstractfactory.Developer;
import org.example.patterns.creational.abstractfactory.ProjectManager;
import org.example.patterns.creational.abstractfactory.ProjectTeamFactory;
import org.example.patterns.creational.abstractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
