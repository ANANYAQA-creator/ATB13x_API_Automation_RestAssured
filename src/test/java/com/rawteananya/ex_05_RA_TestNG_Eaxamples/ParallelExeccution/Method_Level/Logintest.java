package com.rawteananya.ex_05_RA_TestNG_Eaxamples.ParallelExeccution.Method_Level;

import org.testng.annotations.Test;

public class Logintest {

    @Test
    public void valid_Login(){
        System.out.println("valid_login - thread" + Thread.currentThread().getId());
    }

    @Test
    public void Invalid_Login(){

        System.out.println("invalid_login - thread" + Thread.currentThread().getId());
    }

}
