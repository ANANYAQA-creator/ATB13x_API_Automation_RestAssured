package ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class Lab005_RA_Multiple_Testcases {
    public static void main(String[] args) {

        String Pincode = "481001";

        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + Pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

        Pincode = "@" ;
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + Pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

        Pincode = " ";
        RestAssured
                .given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + Pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);


    }
}