package org.example.patterns.creational.builder.chain.lombok;

import org.example.patterns.creational.builder.Cms;

public class VisitCardWebsiteBuilder {
    Website getWebsite() {
        Website.WebsiteBuilder builder = new Website.WebsiteBuilder();
        return builder.name("Visit card")
                .cms(Cms.WORDPRESS)
                .price(500)
                .build();
    }
}
