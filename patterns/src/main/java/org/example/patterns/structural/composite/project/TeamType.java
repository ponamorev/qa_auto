package org.example.patterns.structural.composite.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TeamType {
    STAFF("Staff"),
    OUTSOURCE("Outsource");

    @Getter
    private final String type;
}
