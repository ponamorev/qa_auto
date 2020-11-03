package org.example.patterns.structural.flyweight;

import org.example.patterns.structural.flyweight.developer.CppDeveloper;
import org.example.patterns.structural.flyweight.developer.Developer;
import org.example.patterns.structural.flyweight.developer.JavaDeveloper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DeveloperFactory {
    private static final Map<String, Developer> developers = new HashMap<>();

    public static Developer getDeveloperBySpecialty(String specialty) {
        Developer developer = developers.get(specialty);

        if (Objects.isNull(developer)) {
            switch (specialty) {
                case "java":
                case "Java":
                case "JAVA":
                    System.out.println("Hiring Java developer...");
                    developer = new JavaDeveloper();
                    break;
                case "c++":
                case "C++":
                case "С++":
                case "с++":
                    System.out.println("Hiring C++ developer...");
                    developer = new CppDeveloper();
                    break;
            }
            developers.put(specialty, developer);
        }
        return developer;
    }
}
