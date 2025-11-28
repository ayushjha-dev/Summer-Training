package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame implements MouseListener {
    Label label;

    MouseEventsDemo() {
        addMouseListener(this);
        label = new Label();
        add(label);
        setTitle("Mouse Events Demo");
        setSize(300, 200);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked");
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}
