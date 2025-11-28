package Chapter_01_Java_Fundamentals;
import java.util.Scanner; // Import the Scanner class

public class UserInputDemo { // Class name changed from VariableTypes

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Accept integer input
        System.out.print("Enter an integer: ");
        int wholeNumber = scanner.nextInt();
        System.out.println("You entered an integer: " + wholeNumber);

        // Accept float input
        System.out.print("Enter a decimal number (float): ");
        float decimalNumber = scanner.nextFloat();
        System.out.println("You entered a float: " + decimalNumber);

        // Consume the leftover newline character after nextInt() or nextFloat()
        scanner.nextLine();

        // Accept string input
        System.out.print("Enter some text (String): ");
        String greeting = scanner.nextLine();
        System.out.println("You entered a String: " + greeting);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}



