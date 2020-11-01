package org.example.patterns.creational.builder.chain.lombok;

import lombok.Builder;
import lombok.ToString;
import org.example.patterns.creational.builder.Cms;

@ToString
@Builder
public class Website {
    private String name;
    private Cms cms;
    private int price;
}
