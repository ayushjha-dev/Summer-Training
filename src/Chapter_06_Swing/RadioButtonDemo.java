package Chapter_06_Swing;
import javax.swing.*;
import java.awt.*;
 
public class RadioButtonDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JRadioButton Demo");
        JRadioButton r1 = new JRadioButton("A) Male");
        JRadioButton r2 = new JRadioButton("B) Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        frame.add(r1);
        frame.add(r2);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
