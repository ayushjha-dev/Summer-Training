package Chapter_03_Exception_Handling;
public class HandleArithmeticException {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will cause an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            System.out.println("Exception message: " + e.getMessage());
        }
        System.out.println("Program continues after handling the exception.");
    }
}
