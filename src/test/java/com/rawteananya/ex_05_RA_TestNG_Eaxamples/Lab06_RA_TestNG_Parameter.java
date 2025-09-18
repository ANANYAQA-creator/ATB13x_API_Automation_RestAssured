package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab06_RA_TestNG_Parameter {


    @Parameters ("browser")
    @Test
    public void test_demo1(String value){
        System.out.println("Hi, I am Demo");
        System.out.println("You are running these parameter");

        if (value.equalsIgnoreCase("Chrome"))
        {
        System.out.println("Start the Chrome Browser !!");
        }
        if (value.equalsIgnoreCase("Firefox_Test"))
        {
            System.out.println("Start the Firefox_Test Browser !!");
        }
        if (value.equalsIgnoreCase("Safari"))
        {
            System.out.println("We can't run on Safari !!");
        }
    }

}
