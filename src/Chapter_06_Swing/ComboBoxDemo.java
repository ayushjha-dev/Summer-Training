package Chapter_06_Swing;
import javax.swing.*;

public class ComboBoxDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Demo");
        String[] languages = {"Java", "Python", "C++", "JavaScript"};
        JComboBox<String> comboBox = new JComboBox<>(languages);
        frame.add(comboBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
