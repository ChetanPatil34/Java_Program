import java.util.Scanner;
class Primenum
{
	public static void main(String args[])
	{
		int num,i,c=0;

		System.out.println("Enetr the number");
		Scanner obj=new Scanner(System.in);
		num=obj.nextInt();

		for(i=1; i<=num; i++)
		{
			if(num%i==0)
			c++;
		}
		if(c==2)
		{
			System.out.println("Number is not Prime");
		}
		else
		{
			System.out.println("Number is Prime");
		}

	}

}