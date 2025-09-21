package com.rawteananya.DryRun_HelloWorld;

import io.restassured.RestAssured;

public class RestAssuredHelloWorld {
    public static void main(String[] args) {

        //https://restful-booker.herokuapp.com/ping
        // Status code= 201

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
        .basePath("/ping")
                .when()
                .log().all().get().
                then()
                .log().all().statusCode(201);
    }
}
