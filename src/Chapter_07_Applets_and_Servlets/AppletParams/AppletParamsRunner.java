package Chapter_07_Applets_and_Servlets.AppletParams;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class AppletParamsRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AppletParams Runner");
        AppletParamsPanel panel = new AppletParamsPanel("Hello from AppletParams!");
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
