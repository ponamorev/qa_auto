package org.example.patterns.creational.builder.chain;

import org.example.patterns.creational.builder.Cms;
import org.example.patterns.creational.builder.Website;

public class EnterpriseWebsiteBuilder {
    Website getWebsite() {
        return new WebsiteBuilder()
                .setName("Enterprise web site")
                .setCms(Cms.ALIFRESKO)
                .setPrice(10000)
                .build();
    }
}
