import java.util.Scanner;

class Addition{

   public static void main(String[] args){

	   int a,b,add;

	   Scanner obj = new Scanner(System.in);

	   System.out.println("Enter the Two Number :");

	   a=obj.nextInt();
	   b=obj.nextInt();

	   add=a+b;

	   System.out.println("Addition = "+add);
   }


}