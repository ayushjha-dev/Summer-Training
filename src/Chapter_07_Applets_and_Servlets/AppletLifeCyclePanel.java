package Chapter_07_Applets_and_Servlets;
import javax.swing.*;
import java.awt.*;

public class AppletLifeCyclePanel extends JPanel {
    String message = "";

    public AppletLifeCyclePanel() {
        init();
        start();
    }

    public void init() {
        message = "init() called";
        System.out.println(message);
    }

    public void start() {
        message = "start() called";
        System.out.println(message);
    }

    public void stop() {
        message = "stop() called";
        System.out.println(message);
    }

    public void destroy() {
        message = "destroy() called";
        System.out.println(message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, 20, 20);
    }
}

class AppletLifeCycleRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet Life Cycle Simulation");
        AppletLifeCyclePanel panel = new AppletLifeCyclePanel();
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Simulate stop and destroy when closing
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                panel.stop();
                panel.destroy();
            }
        });
    }
}