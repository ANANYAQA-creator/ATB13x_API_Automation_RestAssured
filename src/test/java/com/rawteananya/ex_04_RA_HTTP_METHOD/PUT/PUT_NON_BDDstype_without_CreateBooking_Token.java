package com.rawteananya.ex_04_RA_HTTP_METHOD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PUT_NON_BDDstype_without_CreateBooking_Token {

    // For PUT request we need TOKEN/Authorization and Request ID - Authentication purpose

    //public void get_token() {}
    //public void get_booking_id() {]

    RequestSpecification r;  // given ()
    Response response ; // when ()
    ValidatableResponse vr; // then()

    @Test
    public void crete_booking(){

        String booking_id = "1892";
        String token = "17f91731b4cc649";

        String payload ="{\n" +
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
        r.basePath("/booking/"+booking_id);
        r.contentType(ContentType.JSON);
        //r.head("Cookie","token"+ token);
        // We have cookie method also so we can use now
        r.cookie("token",token);
        r.body(payload).log().all();

        response= r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
