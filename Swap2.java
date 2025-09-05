public class Swap2 {
    public static void main(String[] args){

        int a=20;
        int b=30;
        int c=40;

        System.out.println("After Swaping Values :");
        System.out.println("A = "+a+",B = "+b+",C = "+ c);

        System.out.println("Before Swaping Values :");
        
        a = a + b + c;
        b = a - (b + c);
        c = a - (b + c);
        a = a - (b + c); 

        System.out.println("A = "+a+",B = "+b+",C = "+ c); 

    }
}
