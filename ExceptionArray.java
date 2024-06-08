
class ExceptionArray{

	public static void main(String[] args){

		int[] a = new int[2];
		a[0] = 10;
		a[1] = 30;

		System.out.println("Starting Program");

		 for(int i=0; i<3; i++)
		 {
			 try{
				 System.out.println(a[i]);
			 }
			 catch(ArrayIndexOutOfBoundsException e)
			 {
				 System.out.println("can not give the array Element");
			 }

		 }

	}
}