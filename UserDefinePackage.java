package myPackage;
class UserDefinePackage
{
	private void add(int x , int y){
		int z = x+y;
		System.out.println("Addition = "+ z);
	}
	private void Sub(int p , int q){

		int c = p-q;
		System.out.println("Subtraction = "+ c);
	}
	public static void main(String args[])
	{
		UserDefinePackage a =new UserDefinePackage();
		a.add( 10,20);
		a.Sub(20,5);
	}
}