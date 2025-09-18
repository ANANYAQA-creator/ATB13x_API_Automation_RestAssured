package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.TestCaseLevel;

import org.testng.annotations.Test;

public class DBSmoke {
    @Test
    public void DBSmoke(){
        System.out.println("DBSMOKE running");
        System.out.println(Thread.currentThread().getId());
    }
}
