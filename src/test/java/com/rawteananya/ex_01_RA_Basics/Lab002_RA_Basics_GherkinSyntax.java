package com.rawteananya.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Lab002_RA_Basics_GherkinSyntax {
    public static void main(String[] args) {


        /* GHERKIN SYNTAX :- GIVEN, WHEN , THEN
        Given() - Pre Request :- ULR, Request, Body, Header ,Parameters
        WHen() - HTTP Method :- GET,PUT,POST, DELETE
        Then() - Validation :- Status code :- 200 , firstname == Shivam

         FULL URL = https://api.zippopotam.us/IN/481001
         Base Url = https://api.zippopotam.us
         BasePath = /IN/481001
        * */

        Scanner pincode = new Scanner(System.in);
        System.out.println("Enter the Pincode = ");
        String Pincode = pincode.next();

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + Pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);

    }
}
