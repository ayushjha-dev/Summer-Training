package Chapter_03_Exception_Handling;
import java.io.IOException;
 
public class ThrowsDemo {
    // This method declares that it can throw an IOException
    void myMethod(int num) throws IOException, ClassNotFoundException {
        if (num == 1)
            throw new IOException("IOException Occurred");
        else
            throw new ClassNotFoundException("ClassNotFoundException Occurred");
    }
 
    public static void main(String args[]) {
        ThrowsDemo obj = new ThrowsDemo();
        try {
            // The call to the method is placed in a try-catch block
            obj.myMethod(1);
        } catch (Exception ex) {
            System.out.println("Caught the exception: " + ex.getMessage());
        }
    }
}
