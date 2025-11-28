package Chapter_03_Exception_Handling;
public class ThrowDemo {
    public static void checkAge(int age) {
        if (age < 18) {
            // Manually throw an exception
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }
 
    public static void main(String[] args) {
        try {
            checkAge(15); // This call will cause an exception
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
