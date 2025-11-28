package Chapter_01_Java_Fundamentals;
public class SwapNumbers {

    public static void main(String[] args) {
        int a = 10; // First number
        int b = 20; // Second number

        System.out.println("Before swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temp; // Declare a temporary variable

        temp = a; // Store the value of 'a' in 'temp'
        a = b;    // Assign the value of 'b' to 'a'
        b = temp; // Assign the value of 'temp' (original 'a') to 'b'

        System.out.println("After swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}