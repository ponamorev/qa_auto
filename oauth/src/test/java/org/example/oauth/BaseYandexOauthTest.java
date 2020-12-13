package org.example.oauth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

//@Slf4j
public class BaseYandexOauthTest {
    // IntellijIDEA 2020.3 doesn't support Lombok plugin, it's temporary declaration
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseYandexOauthTest.class);

    protected static RequestSpecification requestSpecification;

    private static final String APPLICATION_JSON = ContentType.JSON.toString();
    private static final String TOKEN_PROPERTY = "yandex.oauth.token";
    private static final String URL_PATH = "https://cloud-api.yandex.net";
    private static final Header accept = new Header("Accept", APPLICATION_JSON);
    private static final ContentType contentType = ContentType.JSON;
    private static Properties testsProperties;

    @BeforeAll
    protected static void setUp() {
        initProperties();

        String token = testsProperties.getProperty(TOKEN_PROPERTY);
        if (Objects.isNull(token)) {
            log.error("There is no token for tests..");
            Assertions.fail("There is no token for tests..");
        }
        Header authorization = new Header("Authorization", "OAuth " + token);

        requestSpecification = RestAssured.given()
                .header(accept)
                .contentType(contentType)
                .header(authorization)
                .baseUri(URL_PATH);
    }

    private static void initProperties() {
        if (Objects.isNull(testsProperties)) {
            testsProperties = new Properties();
            String propertiesPath = "src/test/resources/application.properties";
            try (FileInputStream inputStream = new FileInputStream(propertiesPath)) {
                testsProperties.load(inputStream);
                log.debug("Successfully load properties for tests");
            } catch (FileNotFoundException fnfEx) {
                log.error("Can't find properties file {}:", propertiesPath, fnfEx);
                throw new RuntimeException("Can't find properties file " + propertiesPath);
            } catch (IOException ioEx) {
                log.error("Can't read properties from file {}", propertiesPath, ioEx);
                throw new RuntimeException("Can't read properties from file " + propertiesPath);
            }
        }
    }
}
