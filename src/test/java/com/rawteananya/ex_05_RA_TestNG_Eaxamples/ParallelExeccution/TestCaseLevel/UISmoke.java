package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.TestCaseLevel;

import org.testng.annotations.Test;

public class UISmoke {
    @Test
    public void UISmoke(){
        System.out.println("UISMOKE running");
        System.out.println(Thread.currentThread().getId());
    }
}
