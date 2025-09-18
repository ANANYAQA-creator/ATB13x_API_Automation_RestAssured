package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.Test;

public class Lab10_RA_TestNG_InvocationCount {

    @Test(invocationCount =2 )
    public void test1()
    {
        System.out.println("test1");
    }

    @Test(invocationCount = 3)
    public void test2(){
        System.out.println("Test2");
    }

}
