package org.example.oauth;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class YandexOauthTest extends BaseYandexOauthTest {
    @Test
    public void test() {
        requestSpecification
                .get("/v1/disk")
                .then()
                .body("is_paid", equalTo(false));
    }
}
