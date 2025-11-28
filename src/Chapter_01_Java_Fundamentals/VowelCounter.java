package Chapter_01_Java_Fundamentals;

public class VowelCounter {
 
    public static void main(String[] args) {
        String text = "Hello World";
        int vowelCount = 0;
 
        text = text.toLowerCase();
 
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
 
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
 
        System.out.println("The string is: \"" + text + "\"");
        System.out.println("Number of vowels: " + vowelCount);
    }
}
