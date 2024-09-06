public class LogicalOperatorsExample {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 30;


        if (a < b && b < c) {
            System.out.println("Both conditions are true: a < b and b < c");
        }


        if (a > b || b < c) {
            System.out.println("At least one condition is true: a > b or b < c");
        }


        boolean isEqual = (a == b);
        if (!isEqual) {
            System.out.println("a is not equal to b");
        }


        if ((a < b && b < c) || (a == 10 && c == 30)) {
            System.out.println("Complex logical condition is true");
        }
    }
}
