package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.Class_Level_CrossBrowserTesting;

import org.testng.annotations.Test;

public class Chrome_Test {

    @Test
    public void chrome(){
        System.out.println("Start the chrome");
        System.out.println(Thread.currentThread().getId());
    }
}
