package Chapter_06_Swing;
import javax.swing.*;
import java.awt.event.*;

public class TempConverter extends JFrame implements ActionListener {
    JTextField input;
    JLabel resultLabel;

    TempConverter() {
        input = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();
        convertButton.addActionListener(this);
        add(new JLabel("Celsius:"));
        add(input);
        add(convertButton);
        add(resultLabel);
        setLayout(new java.awt.FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double celsius = Double.parseDouble(input.getText());
        double fahrenheit = (celsius * 9 / 5) + 32;
        resultLabel.setText("Fahrenheit: " + fahrenheit);
    }

    public static void main(String[] args) {
        new TempConverter();
    }
}
