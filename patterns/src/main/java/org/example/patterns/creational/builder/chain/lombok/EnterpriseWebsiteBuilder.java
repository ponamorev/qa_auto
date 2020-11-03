package org.example.patterns.creational.builder.chain.lombok;

import org.example.patterns.creational.builder.Cms;

public class EnterpriseWebsiteBuilder {
    Website getWebsite() {
        Website.WebsiteBuilder builder = new Website.WebsiteBuilder();
        return builder.name("Enterprise web site")
                .cms(Cms.ALIFRESKO)
                .price(10000)
                .build();
    }
}
