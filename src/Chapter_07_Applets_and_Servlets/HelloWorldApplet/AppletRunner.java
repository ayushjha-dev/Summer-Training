package Chapter_07_Applets_and_Servlets.HelloWorldApplet;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class AppletRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet Runner");
        HelloWorldApplet applet = new HelloWorldApplet();
        frame.add(applet);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        applet.init(); // Optional, if you override init()
        applet.start(); // Optional, if you override start()
    }
}