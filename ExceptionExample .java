public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // Code that may cause an exception
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Catching a specific exception (divide by zero)
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catching a generic exception
            System.out.println("General Exception: " + e.getMessage());
        } finally {
            // This block always runs, whether an exception occurs or not
            System.out.println("Finally block executed.");
        }
    }

    // Method to demonstrate exception
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b; // This will throw ArithmeticException if b is 0
    }
}
