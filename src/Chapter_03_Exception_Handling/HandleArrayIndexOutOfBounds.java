package Chapter_03_Exception_Handling;
public class HandleArrayIndexOutOfBounds {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing element at index 5...");
            int number = numbers[5]; // This will cause an ArrayIndexOutOfBoundsException
            System.out.println("Value: " + number);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: The array index is out of bounds.");
        }
        System.out.println("Program has finished.");
    }
}