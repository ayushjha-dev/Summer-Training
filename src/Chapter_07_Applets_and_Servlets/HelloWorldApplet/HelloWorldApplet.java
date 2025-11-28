package Chapter_07_Applets_and_Servlets.HelloWorldApplet;

import javax.swing.JApplet;
import java.awt.Graphics;

public class HelloWorldApplet extends JApplet {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Hello, World!", 20, 20);
    }
}
