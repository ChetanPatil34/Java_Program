// Defining the interface
interface Animal {
    void sound();  // Method signature - no implementation
    void eat();
}

// Implementing the interface in a class
class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bone");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }

    @Override
    public void eat() {
        System.out.println("Cat drinks milk");
    }
}

// Main class to test the interface
public class InterfaceDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.eat();

        Animal cat = new Cat();
        cat.sound();
        cat.eat();
    }
}
