package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab02_RA_TestNG_BeforeTest_AfterTest {

    // For PUT request - We required
    // 1. getToken
    // 2.  getBookingID
    // 3. test_PUT (which uses the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void get_Token(){
        System.out.println("Before Get_Token");
    }

    @BeforeTest
    public void  getBookingID(){
        System.out.println("Before getBookingID");
    }

    @Test
    public void test_PUT(){

        System.out.println("test_PUT Request");
    }

    @AfterTest
    public void closeAllThing(){
        System.out.println("close all Thing");
    }
}
