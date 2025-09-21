package com.rawteananya.ex_06_RA_TestNG_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab01_RA_Assertions {

    // Non BDD style

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;

    String token;
    Integer bookingID;


    @Test
    public void Create_Booking_POST (){

        // Steps to create booking
        // Payload
        // Given - Setting up the body, basepath,url , uri
        // When - making the request
        //Then  - extraction

String payload = "{\n" +
        "    \"firstname\" : \"Ananya\",\n" +
        "    \"lastname\" : \"Rawte\",\n" +
        "    \"totalprice\" : 1800,\n" +
        "    \"depositpaid\" : true,\n" +
        "    \"bookingdates\" : {\n" +
        "        \"checkin\" : \"2025-08-22\",\n" +
        "        \"checkout\" : \"2025-08-28\"\n" +
        "    },\n" +
        "    \"additionalneeds\" : \"Breakfast,Dinner\"\n" +
        "}";

     rs = RestAssured.given();
     rs.given().baseUri("https://restful-booker.herokuapp.com");
     rs.basePath("/booking");


     //Header Information
     rs.contentType(ContentType.JSON);
     rs.body(payload).log().all();


     response = rs.when().log().all().post();

     // Get Validate response to perform validation

     vr = response.then().log().all();

        // Rest Assured. Assertions
        vr.statusCode(200);

        // BookingID != null
        // firstname = Ananya
        // For this we need to extract the response body

        System.out.println(response.asString());

        // For BookingID != null
        vr.body("bookingid", Matchers.notNullValue());

        // firstname
        vr.body("booking.firstname",Matchers.equalTo("Ananya"));
        vr.body("booking.lastname",Matchers.equalTo("Rawte"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));



    }
}
