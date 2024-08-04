import java.util.Scanner;

class Factorial{

	public static void printFactorial(int n){

		int factorial = 1;

		for(int i=n; i>1; i--)
		{

			factorial = factorial*i;
		}
		System.out.println("Factorial :"+factorial);

		return;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

	    System.out.println("Enter the Number :");

		int n=sc.nextInt();

		 printFactorial(n);
	 }
 }2




