package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.*;

public class Lab11_RA_TestNG_AllAnnotations {

    @BeforeSuite
    public void BeforeSuite (){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void BeforeClass(){

    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Beforemethod");
    }

    @Test
    public void test (){
        System.out.println("Test");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }

}
