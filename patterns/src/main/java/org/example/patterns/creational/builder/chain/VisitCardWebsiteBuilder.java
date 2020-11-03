package org.example.patterns.creational.builder.chain;

import org.example.patterns.creational.builder.Cms;
import org.example.patterns.creational.builder.Website;

public class VisitCardWebsiteBuilder {
    Website getWebsite() {
        return new WebsiteBuilder()
                .setName("Visit card")
                .setCms(Cms.WORDPRESS)
                .setPrice(500)
                .build();
    }
}
