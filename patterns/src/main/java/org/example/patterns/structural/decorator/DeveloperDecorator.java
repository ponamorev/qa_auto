package org.example.patterns.structural.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeveloperDecorator implements Developer {
    private final Developer developer;

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
