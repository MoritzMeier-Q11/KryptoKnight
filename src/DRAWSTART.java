import javax.swing.*;
import java.awt.*;

public class DRAWSTART extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(IMAGELOADER.icon, GUI.width / 2 - 250, 100, 500, 500, null);
        //g.drawImage(IMAGELOADER.startAnimation[ANIMATION.animationImageCount], GUI.width / 2 - 250, 100, 500, 500, null);
        repaint();

    }
}
