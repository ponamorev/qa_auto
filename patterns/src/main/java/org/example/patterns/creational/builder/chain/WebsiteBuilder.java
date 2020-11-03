package org.example.patterns.creational.builder.chain;

import org.example.patterns.creational.builder.Cms;
import org.example.patterns.creational.builder.Website;

public class WebsiteBuilder {
    private Website website;

    WebsiteBuilder() {
        website = new Website();
    }

    WebsiteBuilder setName(String name) {
        website.setName(name);
        return this;
    }

    WebsiteBuilder setCms(Cms cms) {
        website.setCms(cms);
        return this;
    }

    WebsiteBuilder setPrice(int price) {
        website.setPrice(price);
        return this;
    }

    Website build() {
        return website;
    }
}
