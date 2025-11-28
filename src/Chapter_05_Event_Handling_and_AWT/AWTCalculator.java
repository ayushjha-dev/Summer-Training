package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
import java.awt.event.*;
 
public class AWTCalculator extends Frame implements ActionListener {
    TextField display;
    String operator;
    double num1, num2, result;
 
    AWTCalculator() {
        display = new TextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
 
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4, 4));
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (String text : buttons) {
            Button b = new Button(text);
            b.addActionListener(this);
            panel.add(b);
        }
        add(panel);
 
        setTitle("AWT Calculator");
        setSize(400, 400);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
        // Logic for calculator operations
    }
 
    public static void main(String[] args) {
        new AWTCalculator();
    }
}
