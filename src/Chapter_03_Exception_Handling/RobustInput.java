package Chapter_03_Exception_Handling;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class RobustInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;
 
        while (!validInput) {
            try {
                System.out.print("Please enter an integer: ");
                number = scanner.nextInt();
                validInput = true; // If we reach here, input was valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer only.");
                scanner.next(); // Important: consume the invalid input
            }
        }
 
        System.out.println("You entered: " + number);
        scanner.close();
    }
}