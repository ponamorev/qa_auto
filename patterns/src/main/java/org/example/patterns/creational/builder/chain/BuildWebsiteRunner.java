package org.example.patterns.creational.builder.chain;

import org.example.patterns.creational.builder.Website;

public class BuildWebsiteRunner {
    public static void main(String[] args) {
        Website visitCardWebsite, enterpriseWebsite;
        visitCardWebsite = new VisitCardWebsiteBuilder().getWebsite();
        enterpriseWebsite = new EnterpriseWebsiteBuilder().getWebsite();

        System.out.println(visitCardWebsite);
        System.out.println(enterpriseWebsite);
    }
}
