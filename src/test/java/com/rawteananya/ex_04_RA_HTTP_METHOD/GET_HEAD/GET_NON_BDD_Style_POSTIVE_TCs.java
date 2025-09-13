package com.rawteananya.ex_04_RA_HTTP_METHOD.GET_HEAD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NON_BDD_Style_POSTIVE_TCs {
    @Test
    public void GET_NON_BDD_Positve_Pincode () {

        // POSITIVE TESTCASE
        String pincode = "481001";

        RequestSpecification pre_request;      // Pre Request - given() part no usage
        Response reposnse;                     // making the request part -when() part no usage
        ValidatableResponse validater_request; // post request - then() part no usage

        // given()  PART1

        pre_request = RestAssured.given();
        pre_request.baseUri("https://api.zippopotam.us");
        pre_request.basePath("/IN/" + pincode);

        //when()  PART2

        reposnse = pre_request.when().log().all().get();

        //then()  PART3

        validater_request = reposnse.then().log().all();
        validater_request.statusCode(200);

    }
        // Negative TESTCASE

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

