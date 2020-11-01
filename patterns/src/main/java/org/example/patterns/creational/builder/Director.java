package org.example.patterns.creational.builder;

import lombok.Setter;

public class Director {
    @Setter
    WebsiteBuilder websiteBuilder;

    Website buildWebsite() {
        websiteBuilder.createWebsite();
        websiteBuilder.buildName();
        websiteBuilder.buildCms();
        websiteBuilder.buildPrice();

        return websiteBuilder.getWebsite();
    }
}
