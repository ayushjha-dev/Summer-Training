package Chapter_01_Java_Fundamentals;
public class PalindromeChecker {
 
    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversedStr = "";
        // Ignore case sensitivity
        str = str.toLowerCase();
 
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
 
        return str.equals(reversedStr);
    }
 
    public static void main(String[] args) {
        String word1 = "Madam";
        String word2 = "Java";
 
        if (isPalindrome(word1)) {
            System.out.println("'" + word1 + "' is a palindrome.");
        } else {
            System.out.println("'" + word1 + "' is not a palindrome.");
        }
 
        if (isPalindrome(word2)) {
            System.out.println("'" + word2 + "' is a palindrome.");
        } else {
            System.out.println("'" + word2 + "' is not a palindrome.");
        }
    }
}
