class overriding extends c {

	void Show()
	{
		System.out.println("(*_*)");
	}
}
class Child extends overriding{
	void Show()
	{
		System.out.println("(*..*)");
	}
}
class c{
	public static void main(String[] args){
		Child child = new Child();
		child.Show();
	}
}





