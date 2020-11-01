package org.example.patterns.creational.abstractfactory.website;

import org.example.patterns.creational.abstractfactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages website project...");
    }
}
