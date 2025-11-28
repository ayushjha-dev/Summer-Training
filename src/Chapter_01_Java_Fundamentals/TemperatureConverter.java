package Chapter_01_Java_Fundamentals;
public class TemperatureConverter {

    public static void main(String[] args) {
        double celsius = 25.0; // Temperature in Celsius

        // Formula to convert Celsius to Fahrenheit: (Celsius * 9/5) + 32
        double fahrenheit = (celsius * 9/5) + 32;

        System.out.println(celsius + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
    }
}