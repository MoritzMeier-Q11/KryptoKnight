import javax.swing.*;
import java.awt.*;

public class DRAWPONG extends JLabel {

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.fillOval(PONG.x, PONG.y, PONG.size, PONG.size);
        if (GAME.playerList.size() <= 3) {
            g.fillRect(50, PONG.yp1, 20, 100);
            g.fillRect(1850, PONG.yp2, 20, 100);
        } else if (GAME.playerList.size() == 4) {
            g.fillRect(50, PONG.yp1, 20, 50);
            g.fillRect(50, PONG.yp2 + 50, 20, 50);
            g.fillRect(1850, PONG.yp3, 20, 50);
            g.fillRect(1850, PONG.yp4 + 50, 20, 50);
        } else if (GAME.playerList.size() > 4) {
            g.fillOval(420 ,0, GUI.height, GUI.height);
        }
        repaint();
    }
}
