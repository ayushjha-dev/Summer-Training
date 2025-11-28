package Chapter_06_Swing;
import javax.swing.*;
import java.awt.*;

public class UserInputSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Input");
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(20);
        frame.add(label);
        frame.add(textField);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
