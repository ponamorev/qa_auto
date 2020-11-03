package org.example.patterns.structural.flyweight;

import org.example.patterns.structural.flyweight.developer.Developer;

import java.util.ArrayList;
import java.util.List;

import static org.example.patterns.structural.flyweight.DeveloperFactory.getDeveloperBySpecialty;

public class ProjectRunner {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();

        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("java"));
        developers.add(getDeveloperBySpecialty("c++"));
        developers.add(getDeveloperBySpecialty("c++"));
        developers.add(getDeveloperBySpecialty("c++"));
        developers.add(getDeveloperBySpecialty("c++"));
        developers.add(getDeveloperBySpecialty("c++"));
        developers.add(getDeveloperBySpecialty("c++"));

        for (Developer developer : developers) {
            developer.writeCode();
        }
    }
}
