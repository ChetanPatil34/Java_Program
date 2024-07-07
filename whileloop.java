import java.util.Scanner;
class whileloop{

	public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
		int n = 0;

		System.out.println("Enter the Any Number :");
		n=sc.nextInt();
		int i = 0;

		while(i<n)
		{
			System.out.println(i);
			i++;
		}
	}


}