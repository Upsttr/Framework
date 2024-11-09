package api;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AuthService {

    public static String authenticateAndGetUserToken() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();

        String requestBody = "{"
                             + "\"username\": \"raphael\","
                             + "\"password\": \"cool-but-crude\""
                             + "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(baseURI + "/auth/login")
                .then()
                .statusCode(201)
                .extract().response();

        // Извлекаем токен из ответа
        return response.jsonPath().getString("userToken");
    }
}
