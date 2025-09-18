package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.Test;

public class Lab09_RA_TestNG_Soft_Vs_Hard_AlwaysRun {

    @Test
    public void Login(){
// might be fails
    }

    @Test(dependsOnMethods = "Login")
    public void  placeOrder(){  // HARD DEPENDECY
        // IF Login works then able to place order
    }

    @Test (dependsOnMethods = "Login", alwaysRun = true)
    public void closeBrowser(){    // SOFT DEPENDENCY

        // if login failed but still will able to close the browser
    }
}
