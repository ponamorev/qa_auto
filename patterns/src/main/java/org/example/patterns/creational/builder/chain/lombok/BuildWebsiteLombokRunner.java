package org.example.patterns.creational.builder.chain.lombok;

public class BuildWebsiteLombokRunner {
    public static void main(String[] args) {
        Website visitCardWebsite, enterpriseWebsite;
        visitCardWebsite = new VisitCardWebsiteBuilder().getWebsite();
        enterpriseWebsite = new EnterpriseWebsiteBuilder().getWebsite();

        System.out.println(visitCardWebsite);
        System.out.println(enterpriseWebsite);
    }
}
