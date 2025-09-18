package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.Test;

public class Lab01_RA_TestNG_Test {

    public void test_login (){
        //This is a normal function, it will not execute
        System.out.println("test_login");   // not executed.
    }

    @Test
    public void test_login1(){
        // This is the TestNG testcase and it will be executed.
        System.out.println("test_login1"); // executed
    }
}
