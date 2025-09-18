package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab07_RA_TestNG_Enabled {

    @Test
    public void test1 (){
        System.out.println("Run the test1");
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test2 ( ){
        System.out.println("Run the test2");
        Assert.assertTrue(true);
    }

    @Test
    public void test3 (){
        System.out.println("Run the test3");
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test4 (){
        System.out.println("Run the test4");
        Assert.assertTrue(true);
    }
}
