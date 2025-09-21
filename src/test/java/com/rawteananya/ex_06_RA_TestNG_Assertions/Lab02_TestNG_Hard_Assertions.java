package com.rawteananya.ex_06_RA_TestNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab02_TestNG_Hard_Assertions {

    @Test
    public void testHardAssertion (){

        System.out.println("Start the Program");
        Assert.assertEquals("Ananya","ananya");
        System.out.println("End the Program");
    }


}
