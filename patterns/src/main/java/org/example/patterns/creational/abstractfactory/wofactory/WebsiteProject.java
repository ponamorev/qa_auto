package org.example.patterns.creational.abstractfactory.wofactory;

public class WebsiteProject {
    public static void main(String[] args) {
        PhpDeveloper phpDeveloper = new PhpDeveloper();
        ManualTester manualTester = new ManualTester();
        ProjectManager projectManager = new ProjectManager();

        System.out.println("Creating project...");
        phpDeveloper.writeCode();
        manualTester.testCode();
        projectManager.manageProject();
    }
}
