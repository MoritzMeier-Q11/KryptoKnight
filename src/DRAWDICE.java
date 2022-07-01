import javax.swing.*;
import java.awt.*;

public class DRAWDICE extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.white);
        g.fillRect(300, 300, 300, 300);
        //repaint();
    }

}