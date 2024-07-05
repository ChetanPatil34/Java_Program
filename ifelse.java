import java.util.Scanner;
class ifelse{

	public static void main(String[] args){

		int age;

		System.out.println("Enter your age :");

		Scanner sc = new Scanner(System.in);

		age=sc.nextInt();

		if(age>=18)
		{
			System.out.println("Allowed for Voting");
		}
		else{
			System.out.println("Not Allowed for Voting");
		}

	}
}