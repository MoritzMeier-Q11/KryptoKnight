import javax.swing.*;
import java.awt.*;

public class DRAWSNAKE extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        for(int i = 1; i < GUI.height/30; i++) {
            g.drawLine(0, i*30, GUI.width, i*30);
        }
        for(int i = 1; i < GUI.width/30; i++) {
            g.drawLine(i*30, 0, i*30, GUI.height);
        }
    }
}
