package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab05_RA_TestNG_DependsOnMethods {

    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "serverStartedOk")
    public void test1(){
        System.out.println("Method-1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("Method-2");
        Assert.assertTrue(true);
    }

}
