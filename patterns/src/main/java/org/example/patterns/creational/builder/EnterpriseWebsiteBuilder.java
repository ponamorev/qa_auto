package org.example.patterns.creational.builder;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("Enterprise web site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALIFRESKO);
    }

    @Override
    void buildPrice() {
        website.setPrice(10000);
    }
}
