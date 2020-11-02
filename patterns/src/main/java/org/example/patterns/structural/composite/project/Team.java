package org.example.patterns.structural.composite.project;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class Team implements Developer {
    private final List<Developer> team = new ArrayList<>();
    private TeamType type;

    public Team(TeamType type) {
        this.type = type;
    }

    @Override
    public void add(Developer developer) {
        team.add(developer);
    }

    @Override
    public void createProject() {
        String teamCreatingProjectMessage = Objects.isNull(type)
                ? "Whole team creating project..."
                : type.getType() + " team taking part in creating project...";
        System.out.println(teamCreatingProjectMessage);

        for (Developer dev : team) {
            dev.createProject();
        }
    }
}
