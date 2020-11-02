package org.example.patterns.structural.composite.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DeveloperLevel {
    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    @Getter
    private final String level;
}
