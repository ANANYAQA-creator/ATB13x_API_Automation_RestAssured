package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab04_RA_TestNG_Groups {

    @Test (groups = {"reg","Sanity"})
    public void sanity_tcs (){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg","smoke"})
    public void smoke_tcs () {
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(false);
    }


    @Test (groups = {"reg"})
    public void regression_tcs(){
        System.out.println("regression");
        System.out.println("QA");
        Assert.assertTrue(false);
    }
}
