import javax.swing.*;
import java.awt.*;

public class DRAWPONG extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.fillOval(PONG.x, PONG.y, PONG.size, PONG.size);
        repaint();
    }
}
