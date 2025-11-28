package Chapter_03_Exception_Handling;
import java.util.Scanner;
 
public class TryWithResourcesDemo {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name);
        }
        // The scanner is automatically closed here, no finally block needed.
        System.out.println("Scanner was closed automatically.");
    }
}