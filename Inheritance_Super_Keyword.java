class Inheritance_Super_Keyword extends c{

	void Show()
	{
		System.out.println("Parent Show");
	}

}
class Child extends  Inheritance_Super_Keyword{
    void Show()
    {
	    super.Show();

		System.out.println("Child");
	}

}
class c{

	public static void main(String[] args)
	{
		Child c = new Child();
		c.Show();
	}
}
