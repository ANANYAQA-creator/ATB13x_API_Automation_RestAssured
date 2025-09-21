package com.rawteananya.ex_06_RA_TestNG_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Lab04_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;
    String token;
    Integer bookingID;
    boolean depositpaid;



    @Test
    public void Create_Booking_POST() {

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


        r = rs.when().log().all().post();

        // Get Validate response to perform validation

        vr = r.then().log().all();

        // Rest Assured. Assertions
        vr.statusCode(200);


        // REST_ASSURED_Assertions [4 to 5% used] --> import org.hamcrest.Matchers
        // eg Matchers.equalto()

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Ananya"));
        vr.body("booking.lastname",Matchers.equalTo("Rawte"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));

        // TestNG_Assertions --> Extract the details of the firstname,lastname,bookingID
        //Extraction

        // Concept1 for Extraction = (TestNG or assertj ) is Important
        bookingID = r.then().extract().path("bookingid");
        String firstname = r.then().extract().path("booking.firstname");
        String lastname = r.then().extract().path("booking.lastname");
        boolean deposit = r.then().extract().path("booking.depositpaid");

        // Concept2 for Extraction = [JsonPath class] another mechanism to extract the keys, value from JSONPath

        JsonPath jsonPath = new JsonPath(r.asString());
        String bookingID1 = jsonPath.getString("bookingid");

        assertThat(jsonPath.getString("booking.firstname")).isEqualTo("Ananya");
        assertThat(jsonPath.getString("booking.lastname")).isEqualTo("Rawte");

        //TestNG Assertions
        // HardAssertion[90%] - if the assertion fails it's stop immediately.
        // SoftAssertion[10%] - if the assertion fails then the remaining test method runs continously.

        Assert.assertEquals(firstname,"Ananya");
        Assert.assertEquals(lastname,"Rawte");
        Assert.assertNotNull(bookingID);


        // for just usage  assert.fail()  - if we want to fail the test
        if (!firstname.contains("Ananya")){
            Assert.fail("Fail the Test");
            System.out.println("Fail the test");
        }

        // assertJ =3rd Party Library for Assertions[20%]

        assertThat(bookingID).isNotNull().isNotNegative().isPositive();
        assertThat(firstname).isNotNull().isNotEmpty().isEqualTo("Ananya");
        assertThat(deposit).isTrue();






    }
}