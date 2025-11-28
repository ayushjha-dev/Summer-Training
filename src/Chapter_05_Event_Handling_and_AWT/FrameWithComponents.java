package Chapter_05_Event_Handling_and_AWT;
import java.awt.*;

public class FrameWithComponents extends Frame {
    FrameWithComponents() {
        Label label = new Label("This is a label.");
        Button button = new Button("Click Me!");
        add(label);
        add(button);
        setLayout(new FlowLayout());
        setTitle("Frame with Components");
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameWithComponents();
    }
}
