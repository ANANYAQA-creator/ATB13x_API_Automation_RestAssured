package com.rawteananya.ex_04_RA_HTTP_METHOD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PUT_NON_BDD_Style_withCreateBooking_Token {

    /*
     *1. Create Booking
     *2. Generate Token
     *3. Update the Request
     * */

    RequestSpecification r;
    Response rs;
    ValidatableResponse vr;

    String token;   // ✅ Generated Token
    int bookingID;  // ✅ First booking


    @Test
    public void Create_Booking() {

        String createbooking_payload = "{\n" +
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

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(createbooking_payload).log().all();

        rs = r.when().log().all().post();
        vr = rs.then().log().all().statusCode(200);

        bookingID = rs.jsonPath().getInt("bookingid");
        System.out.println("Created Booking ID :- " + bookingID);

    }

    // Generate Token
    @Test (dependsOnMethods = "Create_Booking")
    public void Generate_Token( ) {

        String Generate_token_payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

    r= RestAssured.given();
    r.baseUri("https://restful-booker.herokuapp.com/");
    r.basePath("/auth");
    r.contentType(ContentType.JSON);
    r.body(Generate_token_payload).log().all();

    rs = r.when().log().all().post();

    vr = rs.then().log().all().statusCode(200);

    token = rs.jsonPath().getString("token");
        System.out.println("Generated Token :- " + token);

    }

    // Update the details in Booking

    @Test (dependsOnMethods = "Generate_Token")
    public void Update_Booking_Details(){

        String Update_booking_payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"lunch\"\n" +
                "}";


        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+bookingID);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);   // ✅ attach fresh token
        r.body(Update_booking_payload).log().all();
        rs= r.when().log().all().put();
        vr = rs.then().log().all().statusCode(200);

    }
}