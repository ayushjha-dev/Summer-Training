package Chapter_01_Java_Fundamentals;
public class BasicCalculator {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        int sum = num1 + num2;
        System.out.println("Sum: " + sum);

        int difference = num1 - num2;
        System.out.println("Difference: " + difference);

        int product = num1 * num2;
        System.out.println("Product: " + product);

        double quotient = (double) num1 / num2;
        System.out.println("Quotient: " + quotient);
    }
}