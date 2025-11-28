package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
import java.awt.event.*;
 
public class WindowClosingDemo extends Frame {
    WindowClosingDemo() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setTitle("Window Closing Demo");
        setSize(300, 200);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new WindowClosingDemo();
    }
}
