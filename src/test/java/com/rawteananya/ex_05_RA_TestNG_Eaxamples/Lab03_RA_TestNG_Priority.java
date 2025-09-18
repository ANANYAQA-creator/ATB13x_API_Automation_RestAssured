package com.rawteananya.ex_05_RA_TestNG_Eaxamples;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Lab03_RA_TestNG_Priority {

    @Test(priority = 1)
    public void test_t1(){
        System.out.println("1");
    }

    @Test(priority = 3)
    public void test_t2(){
        System.out.println("3");
    }

    @Test(priority = 2)
    public void test_t3(){
        System.out.println("2");
    }

    @Test(priority = 4)
    public void test_t4(){
        System.out.println("4");
    }

    @Test (priority = 4)
    public void test_tA(){
        System.out.println("A");
    }

    @Test (priority = 3)
    public void test_tC(){
        System.out.println("B");
    }

    @Test(priority = 2)
    public void test_tB(){
        System.out.println("C");
    }

    @Test (priority = 1)
    public void test_tD(){
        System.out.println("D");
    }

}
