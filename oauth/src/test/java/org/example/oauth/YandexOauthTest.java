package org.example.oauth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.in;

public class YandexOauthTest extends BaseYandexOauthTest {
    private final String TEST_FOLDER_NAME = "TestFolder";

    @BeforeEach
    public void removeTestFolders() {
        requestSpecification
                .queryParam("path", TEST_FOLDER_NAME)
                .queryParam("permanently", true)
                .delete("/v1/disk/resources")
                .then()
                .statusCode(in(Arrays.asList(204, 404)));
    }

    @Test
    public void test() {
        requestSpecification
                .get("/v1/disk")
                .then()
                .body("is_paid", equalTo(false));
    }

    @Test
    public void createAndDeleteFolderTest() {
        requestSpecification
                .queryParam("path", TEST_FOLDER_NAME)
                .put("/v1/disk/resources")
                .then()
                .statusCode(201)
                .body("href", endsWith("/v1/disk/resources?path=disk%3A%2F" + TEST_FOLDER_NAME));

        requestSpecification
                .queryParam("path", TEST_FOLDER_NAME)
                .queryParam("permanently", true)
                .delete("/v1/disk/resources")
                .then()
                .statusCode(204);
    }

    @Test
    public void uploadFileToFolderTest() {
        String fileUri = "file:///" + new File("scr/test/resources/test_file.txt").getAbsolutePath();
        System.out.println(fileUri);
        requestSpecification
                .queryParam("path", TEST_FOLDER_NAME)
                .put("/v1/disk/resources")
                .then()
                .statusCode(201);

        String response = requestSpecification
                .queryParam("path", TEST_FOLDER_NAME)
                .queryParam("url", fileUri)
                .post("/v1/disk/resources/upload")
                .thenReturn().asPrettyString();
        System.out.println(response);
    }
}
