package api;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RandomDataGenerator;

import static io.restassured.RestAssured.given;

public class CompanyService {

    public static int createCompanyAndGetId(String userToken) {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
        String companyName = RandomDataGenerator.generateRandomCompanyName();
        String description = RandomDataGenerator.generateRandomDescription();

        String requestBody = "{"
                             + "\"name\": \"" + companyName + "\","
                             + "\"description\": \"" + description + "\""
                             + "}";

        Response response = given()
                .header("x-client-token", userToken)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/company")
                .then()
                .statusCode(201)
                .extract().response();

        return response.jsonPath().getInt("id");


    }

    public static Response getCompanyDetails(int companyId, String token) {
        RestAssured.baseURI = ConfigManager.getBaseUrl();

        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/companies/" + companyId)
                .then()
                .statusCode(200)
                .extract().response();
    }

}
