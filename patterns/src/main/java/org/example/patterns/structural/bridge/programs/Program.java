package org.example.patterns.structural.bridge.programs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.patterns.structural.bridge.developers.Developer;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Program {
    protected Developer developer;

    public abstract void developProgram();
}
