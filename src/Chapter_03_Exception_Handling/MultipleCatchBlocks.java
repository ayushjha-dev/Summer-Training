package Chapter_03_Exception_Handling;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number to divide 100 by: ");
            int divisor = scanner.nextInt();
            int result = 100 / divisor;
            System.out.println("Result: " + result);
 
            int[] arr = new int[result];
            System.out.println("Array created with size: " + result);
            arr[10] = 5; // Might cause ArrayIndexOutOfBoundsException
 
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (Exception e) { // A general catch block for other exceptions
            System.out.println("An unexpected error occurred: " + e);
        }
        scanner.close();
    }
}
