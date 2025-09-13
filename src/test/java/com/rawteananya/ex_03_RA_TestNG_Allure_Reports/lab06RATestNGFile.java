package com.rawteananya.ex_03_RA_TestNG_Allure_Reports;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class lab06RATestNGFile {

    String  pincode;

    @Test

    //input valid pincode = 481001
    public void test_tc1_pincode_valid() {

        pincode = "481001";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);
    }

    @Test
    // input invalid pincode = @, $ & % *
    public void test_tc2_pincode_invalid(){
        pincode = "@";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);
    }

    @Test
    // input invalid pincode blank = '  '
    public void  test_tc3_pincode_invalid(){

        pincode = "  ";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

    }

}
