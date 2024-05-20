interface MyInterface
{
	int a=10;
	void fun1();
	void fun2();
	default void fun3()
	{
		System.out.println("This is Fun3");
	}
	static void fun4()
	{
		System.out.println("This is Fun4");
	}
}
class InterfaceDemo2
{
	public static void main(String args[])
	{
		MyInterface M = new MyInterface(){
			public void fun1()
			{
			System.out.println("This is Fun1");
			}
			public void fun2()
			{							System.out.println("This is Fun2");
			}
		};
		M.fun1();
		M.fun2();
	}
}	