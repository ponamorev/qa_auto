package org.example.patterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class ProjectFactory {
    private Project project;

    Project cloneProject() {
        return (Project) project.copy();
    }
}
