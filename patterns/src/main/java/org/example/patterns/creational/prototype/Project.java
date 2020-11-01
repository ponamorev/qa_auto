package org.example.patterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Project implements Copyable {
    private int id;
    private String projectName;
    private String sourceCode;

    @Override
    public Object copy() {
        Project copy = new Project(id, projectName, sourceCode);
        return copy;
    }
}
