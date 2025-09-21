package com.rawteananya.ex_06_RA_TestNG_Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab03_TestNG_Soft_Assertions {

    @Test
    public void Test_Soft_Assert() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start the Program");
        softAssert.assertEquals("ananya", "Ananya");
        System.out.println("End the Program");
        softAssert.assertAll();
    }
}
