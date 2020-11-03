package org.example.patterns.structural.bridge;

import org.example.patterns.structural.bridge.developers.CppDeveloper;
import org.example.patterns.structural.bridge.developers.JavaDeveloper;
import org.example.patterns.structural.bridge.programs.BankSystem;
import org.example.patterns.structural.bridge.programs.Program;
import org.example.patterns.structural.bridge.programs.StockExchange;

public class ProgramCreator {
    public static void main(String[] args) {
        Program[] programs = {
                new BankSystem(new JavaDeveloper()),
                new StockExchange(new CppDeveloper())
        };

        for (Program program : programs) {
            program.developProgram();
        }

        System.out.println("\n\n");

        programs = new Program[]{
                new BankSystem(new CppDeveloper()),
                new StockExchange(new JavaDeveloper())
        };

        for (Program program : programs) {
            program.developProgram();
        }
    }
}
