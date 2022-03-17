import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DRAW extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, GUI.width, GUI.height);
        g.setColor(Color.ORANGE);
        g.drawLine(0, 0, 100, 100);
        g.drawImage(IMAGELOADER.icon, 0, -300, null);
        repaint();
    }
}
