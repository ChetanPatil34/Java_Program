package com.chetan.factorialnum;

import java.util.Scanner;

public class FactorialNum {

	public static void main(String[] args) {
		int Factorial = 1;
		int Number = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number = ");
		Number=scanner.nextInt();
		
		for(int i=1; i<=Number; i++)
		{
			Factorial *=i;
		}
		System.out.println("Factorial of = "+Number+" is "+Factorial);
		scanner.close();
	}


}
