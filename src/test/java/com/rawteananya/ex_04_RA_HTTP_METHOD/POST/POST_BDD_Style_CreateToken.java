package com.rawteananya.ex_04_RA_HTTP_METHOD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class POST_BDD_Style_CreateToken {

    @Test
    public  void POST_BDD_CreateToken (){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .when().log().all()
                .post()
                .then()
                .log().all().statusCode(200);

    }
}
