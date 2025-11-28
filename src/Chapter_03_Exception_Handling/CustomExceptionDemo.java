package Chapter_03_Exception_Handling;
// InvalidAgeException.java
// A custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String str) {
        // Calling constructor of parent Exception
        super(str);
    }
}

// CustomExceptionDemo.java
public class CustomExceptionDemo {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw an object of our custom exception
            throw new InvalidAgeException("Age is not valid to vote");
        } else {
            System.out.println("Welcome to vote");
        }
    }

    public static void main(String args[]) {
        try {
            validate(13);
        } catch (InvalidAgeException ex) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + ex.getMessage());
        }
        System.out.println("Rest of the code...");
    }
}
