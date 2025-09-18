package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.TestCaseLevel;

import org.testng.annotations.Test;

public class APISmoke {

    @Test
    public void APISmoke(){
        System.out.println("APISMOKE running");
        System.out.println(Thread.currentThread().getId());
    }
}
