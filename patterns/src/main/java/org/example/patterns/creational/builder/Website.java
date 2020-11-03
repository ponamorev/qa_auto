package org.example.patterns.creational.builder;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class Website {
    private String name;
    private Cms cms;
    private int price;
}
