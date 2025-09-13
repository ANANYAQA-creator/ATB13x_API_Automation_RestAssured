package com.rawteananya.ex_04_RA_HTTP_METHOD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NON_BDD_DELETE {

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

        // Delete the Booking

        @Test (dependsOnMethods = "Generate_Token")
        public void Update_Booking_Details(){


            r= RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com/");
            r.basePath("/booking/"+bookingID);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);   // ✅ attach fresh token
            rs= r.when().log().all().delete();
            vr = rs.then().log().all().statusCode(201);

        }
    }

