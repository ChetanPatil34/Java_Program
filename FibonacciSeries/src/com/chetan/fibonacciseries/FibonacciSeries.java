package com.chetan.fibonacciseries;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		
       int num1 = 0;
       int num2 = 1;
       int num3;
       
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Enter length for fibonascci series");
       int length = scanner.nextInt();
     
       System.out.println("Fibonacci Series upto"+"number\n");
       
       for(int i = 0; i < length; i ++)
       {
    	   System.out.println(num1);
    	   num3 = num1 + num2;
    	   num1 = num2;
    	   num2 = num3;
    	   
       }
     
	scanner.close();
       
       
    		   
	}

}
