public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;

        System.out.println("After Swaping Values :");
        System.out.println("A = "+a+",B = "+b+",temp = ");

        System.out.println("Before Swaping Values :");

        temp = a; 
        a = b;     
        b = temp;

        System.out.println("A = "+a+",B = "+b+",temp = "+temp);
    }
}
