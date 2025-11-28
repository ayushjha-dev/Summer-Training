package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
import java.awt.event.*;
 
public class ButtonClickDemo extends Frame implements ActionListener {
    Label label;
 
    ButtonClickDemo() {
        label = new Label();
        Button button = new Button("Click Me!");
        button.addActionListener(this);
        add(button);
        add(label);
        setLayout(new FlowLayout());
        setTitle("Button Click Demo");
        setSize(300, 200);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
        label.setText("Button Clicked!");
    }
 
    public static void main(String[] args) {
        new ButtonClickDemo();
    }
}
