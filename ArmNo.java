import java.util.*;

class ArmNo{

		public static void main(String args[])
		{ 
			
			int num;
			
			System.out.print("Enter a number :");
			Scanner obj = new Scanner(System.in);
			num=obj.nextInt();

			int temp , sum=0, r;		

			temp=num;

			while(num>0)
			{
				r=num%10;
				sum=sum+(r*r*r);
				num=num/10;
			}

			if(sum==temp)
			{
				System.out.print("Number is Armstrong");
			}
			else
			{
				System.out.print("Number is Not Armstrong");				
			}
			
		
		}
}