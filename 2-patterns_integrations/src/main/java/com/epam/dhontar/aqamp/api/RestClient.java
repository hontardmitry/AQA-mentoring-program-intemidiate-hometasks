package com.epam.dhontar.aqamp.api;

import static com.epam.dhontar.aqamp.utils.enums.ServicesEndpoints.BASE_URL;

import static io.restassured.RestAssured.given;

import com.epam.dhontar.aqamp.utils.enums.ServicesEndpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {
    private String url;
    public Response getEntityById(int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(url + id);
    }

    public Response deleteEntity(int id) {
        return given()
            .contentType(ContentType.JSON)
            .when()
            .delete(url + id);
    }

    public Response postEntity(Object object) {
        return given()
            .contentType(ContentType.JSON)
            .body(object)
            .when()
            .post(url);
    }

    public RestClient(ServicesEndpoints endpoint){
        this.url = BASE_URL.getValue() + endpoint.getValue();
    }
}
