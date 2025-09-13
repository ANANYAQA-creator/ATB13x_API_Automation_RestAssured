package com.rawteananya.ex_04_RA_HTTP_METHOD.GET_HEAD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NON_BDD_Style_NEGATIVE_TCs {

    @Test
    public void Get_Non_BDD_Negative_Tcs_Pincode (){

        RequestSpecification r; // given() part
        Response response; // when() part
        ValidatableResponse vr; // then() part

        String pincode = "@";

        // Given()
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        // When()
        response = r.when().log().all().get();

        // Then()

        vr = response.then().log().all();
        vr.statusCode(404);
    }
}
