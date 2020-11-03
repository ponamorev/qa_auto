package org.example.patterns.creational.abstractfactory.website;

import org.example.patterns.creational.abstractfactory.Developer;
import org.example.patterns.creational.abstractfactory.ProjectManager;
import org.example.patterns.creational.abstractfactory.ProjectTeamFactory;
import org.example.patterns.creational.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
