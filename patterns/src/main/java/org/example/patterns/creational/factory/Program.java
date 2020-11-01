package org.example.patterns.creational.factory;

import org.example.patterns.creational.factory.developer.*;
import org.example.patterns.creational.factory.developer.CppDeveloper;
import org.example.patterns.creational.factory.developer.JavaDeveloper;

public class Program {
    public static void main(String[] args) {
        // --- option 1
//        JavaDeveloper javaDeveloper = new JavaDeveloper();
//
//        javaDeveloper.writeJavaCode();

//        CppDeveloper cppDeveloper = new CppDeveloper();
//
//        cppDeveloper.writeCppCode();

        // --- option 2
//        Developer developer = new JavaDeveloper();
//        Developer developer = new CppDeveloper();
//        developer.writeCode();

        // --- option 3
//        DeveloperFactory developerFactory = new JavaDeveloperFactory();
//        DeveloperFactory developerFactory = new CppDeveloperFactory();
//        Developer developer = developerFactory.createDeveloper();
//        developer.writeCode();

        // --- option 4
        DeveloperFactory developerFactory = createDeveloperBySpecialty("php");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    private static DeveloperFactory createDeveloperBySpecialty(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + " is unknown");
        }
    }
}
