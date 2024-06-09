import java.util.Scanner;
class ReversNo{

	public static void main(String args[]){

		int r,n,sum=0;

		Scanner obj = new Scanner(System.in);

		System.out.println("\nEnter the Number :");
		n=obj.nextInt();

		do{
	      	r=n%10;
	      	System.out.println(r);
	      	n=n/10;
	      	sum=sum+r;
		}
		while(n>0);
		System.out.println("\nSum :"+sum);
	}
}