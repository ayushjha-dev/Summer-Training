package Chapter_06_Swing;
import javax.swing.*;

public class SimpleFrameSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Swing Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
