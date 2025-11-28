package Chapter_01_Java_Fundamentals;
public class StringIntConverter {

    public static void main(String[] args) {
        // --- Converting String to int ---
        String strNumber = "123";
        System.out.println("Original String: \"" + strNumber + "\"");

        // Using Integer.parseInt() to convert String to int
        int intNumber = Integer.parseInt(strNumber);
        System.out.println("Converted to int: " + intNumber);

        // You can now perform arithmetic operations on intNumber
        int result = intNumber + 7;
        System.out.println("int after addition: " + result);

        // --- Converting int to String ---
        int anotherInt = 456;
        System.out.println("\nOriginal int: " + anotherInt);

        // Method 1: Using String.valueOf()
        String strFromInt1 = String.valueOf(anotherInt);
        System.out.println("Converted to String (Method 1): \"" + strFromInt1 + "\"");

        // Method 2: Using Integer.toString()
        String strFromInt2 = Integer.toString(anotherInt);
        System.out.println("Converted to String (Method 2): \"" + strFromInt2 + "\"");

        // Method 3: Concatenating with an empty string (simple but less explicit)
        String strFromInt3 = "" + anotherInt;
        System.out.println("Converted to String (Method 3): \"" + strFromInt3 + "\"");
    }
}
