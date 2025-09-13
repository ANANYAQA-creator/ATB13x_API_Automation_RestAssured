package com.rawteananya.ex_04_RA_HTTP_METHOD.GET_HEAD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_BDD_Style {

    @Test

    public void Get_BDD_Pincode(){

        String pincode = "481001";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all()
                .statusCode(200);

    }
}
