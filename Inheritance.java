class Inherit{

	void display(){
		System.out.println("chetan");
	}
}
class Inheritance extends Inherit{

	void Display(){
		System.out.println("Patil");
	}

public static void main(String[] args){

	Inheritance inheritance = new Inheritance();
	 inheritance.display();
	 inheritance.Display();
 }
}

