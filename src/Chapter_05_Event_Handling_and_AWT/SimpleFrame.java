package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
 
public class SimpleFrame extends Frame {
    SimpleFrame() {
        setTitle("Simple AWT Frame");
        setSize(300, 200);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new SimpleFrame();
    }
}