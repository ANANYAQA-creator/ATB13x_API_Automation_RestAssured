package com.rawteananya.ex_04_RA_HTTP_METHOD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POST_NON_BDD_Style_createToken {

    @Test
    public void POST_NON_BDD_createToken(){

        /*
        1. URl :- https://restful-booker.herokuapp.com/auth
        2. Payload :- {
    "username" : "admin",
    "password" : "password123"
          }
        3. HEADER :- Content-Type = "application/json"
        4.Authentication = NA
        5.Cookie = NA
        6. Validation = 200 OK
        7.Body Response = Token is generated or not
         */


        RequestSpecification r;   // given
        Response response; // when
        ValidatableResponse vr; // then

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println("-----PART1---------");
        //PART1   :- given() pre reuqest - URL,Header,Authentication
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);

        // if want to add header,authentication,Oauth2

     //   r.header("Content-length","1000");
      //  r.auth().basic("admin","password");
       // r.auth().oauth2("POST_NON_BDD_createToken");
        // Bearer is always add like a authorization
       //r.header("Authorization","Bearer ey3492r9098324255");

        r.body(payload).log().all();

        System.out.println("---------PART2----------");
        //PART2 :- when () // Making HTTP request
        response = r.when().log().all().post();

        System.out.println("------------PART3-----------");
        //PART3 ;- Verification response

        vr= response.then().log().all();
        vr.statusCode(200);


    }
}
