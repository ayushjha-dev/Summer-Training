package Chapter_07_Applets_and_Servlets.AppletParams;

import javax.swing.JPanel;
import java.awt.Graphics;

public class AppletParamsPanel extends JPanel {
    private String message;

    public AppletParamsPanel(String message) {
        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, 50, 25);
    }
}
