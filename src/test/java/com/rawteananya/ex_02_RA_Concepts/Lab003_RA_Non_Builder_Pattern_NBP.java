package com.rawteananya.ex_02_RA_Concepts;

public class Lab003_RA_Non_Builder_Pattern_NBP {


        // No Design Pattern

        public void Step1(){
            System.out.println("Step1");         // Type1 of function :- No return type, No Arguments
        }

    public void Step2(){
        System.out.println("Step2");         // Type1 of function :- No return type, No Arguments
    }

    public void Step3 (String param1){
        System.out.println("Ste3");   // Type2 of Function = No return type, with Aruguments()
    }

    public static void main(String[] args) {
        Lab003_RA_Non_Builder_Pattern_NBP nbp = new Lab003_RA_Non_Builder_Pattern_NBP();
        nbp.Step1();
        nbp.Step2();
        nbp.Step3("Shivam");
    }
}

