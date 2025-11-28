package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
 
public class LayoutManagersDemo {
    public static void main(String[] args) {
        // FlowLayout
        Frame flowFrame = new Frame("FlowLayout");
        flowFrame.setLayout(new FlowLayout());
        flowFrame.add(new Button("1"));
        flowFrame.add(new Button("2"));
        flowFrame.add(new Button("3"));
        flowFrame.setSize(300, 100);
        flowFrame.setVisible(true);
 
        // BorderLayout
        Frame borderFrame = new Frame("BorderLayout");
        borderFrame.setLayout(new BorderLayout());
        borderFrame.add(new Button("North"), BorderLayout.NORTH);
        borderFrame.add(new Button("South"), BorderLayout.SOUTH);
        borderFrame.setSize(300, 150);
        borderFrame.setVisible(true);
 
        // GridLayout
        Frame gridFrame = new Frame("GridLayout");
        gridFrame.setLayout(new GridLayout(2, 2));
        gridFrame.add(new Button("1"));
        gridFrame.add(new Button("2"));
        gridFrame.add(new Button("3"));
        gridFrame.add(new Button("4"));
        gridFrame.setSize(300, 300);
        gridFrame.setVisible(true);
    }
} 
