interface X {
    default void display() {
        System.out.println("Display from Interface X");
    }
}

interface A extends X {
    default void display() {
        System.out.println("Display from Interface A");
    }
}

interface B extends X {
    default void display() {
        System.out.println("Display from Interface B");
    }
}

class C implements A, B {
    // Explicitly overriding the display method to resolve the conflict
    @Override
    public void display() {
        // We can choose to call a specific interface's method if needed
        A.super.display(); // Or B.super.display();
        System.out.println("Display from Class C");
    }

    public static void main(String[] args) {
        C obj = new C();
        obj.display();  // Output: "Display from Interface A" followed by "Display from Class C"
    }
}
