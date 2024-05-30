public class Constructor {
    private int num;

    public Constructor() {

    }

    public void ConstructorExample() {
        num = 0;
    }

    public void ConstructorExample(int value) {
        num = value;
    }

    public void display() {

        System.out.println("Value of num: " + num);
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor();
        obj1.display();

        Constructor obj2 = new Constructor();
        obj2.display();
    }

}
