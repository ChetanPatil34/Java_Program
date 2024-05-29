import java.util.*;
class Arraylength
{
	input
	public static void main(String args[])
	{

		int size;
		System.out.println("Enter the size element:");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();

		int a[]=new int[size];
		System.out.println("Array length= "+a.length);

		int i;

		System.out.println("Enter the array element= ");
		for( i=0;i<a.length;i++)
		{
			 a[i]=sc.nextInt();

	    }
	    System.out.println("Array element is=");
	    for(int j=0;j<a.length;j++)
	    {
	       System.out.println(a[j]);
	   }
	}
}