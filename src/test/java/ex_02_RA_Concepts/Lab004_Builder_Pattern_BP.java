package ex_02_RA_Concepts;

public class Lab004_Builder_Pattern_BP {

    public  Lab004_Builder_Pattern_BP Step1(){
        System.out.println("Step1");// Type1 of function :- No return type, No Arguments
        return this;
    }

    public  Lab004_Builder_Pattern_BP Step2(){
        System.out.println("Step2");         // Type1 of function :- No return type, No Arguments
        return this;
    }

    public Lab004_Builder_Pattern_BP Step3 (String param1){
        System.out.println("Ste3");   // Type2 of Function = No return type, with Aruguments()
        return this;
    }

    public static void main(String[] args) {
        Lab004_Builder_Pattern_BP bp = new Lab004_Builder_Pattern_BP();
        bp.Step1().Step2().Step3("Shiv");

    }


}
