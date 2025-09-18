package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.Class_Level_CrossBrowserTesting;

import org.testng.annotations.Test;

public class Firefox_Test {

    @Test
    public void firefox(){
        System.out.println("Start the firefox");
        System.out.println(Thread.currentThread().getId());
    }
}
