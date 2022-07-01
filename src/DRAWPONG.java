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
            g.setColor(GAME.playerList.get(0).color);
            g.fillRect(1850, PONG.yp2, 20, 100);
            g.setColor(GAME.playerList.get(1).color);
        } else if (GAME.playerList.size() == 4) {
            g.fillRect(50, PONG.yp1, 20, 50);
            g.setColor(GAME.playerList.get(1).color);
            g.fillRect(50, PONG.yp2 + 50, 20, 50);
            g.setColor(GAME.playerList.get(2).color);
            g.fillRect(1850, PONG.yp3, 20, 50);
            g.setColor(GAME.playerList.get(3).color);
            g.fillRect(1850, PONG.yp4 + 50, 20, 50);
        } else if (GAME.playerList.size() > 4) {
            g.setColor(Color.white);
            g.fillOval(PONG.x+GUI.width/2-15, PONG.y+GUI.height/2-15, PONG.size, PONG.size);
            g.drawOval(GUI.width/2-500 ,GUI.height/2-500, GUI.height - 80, GUI.height - 80);
            g.setColor(GAME.playerList.get(0).color);
            g.fillRect(510, PONG.yp1, 20, 100);
            g.setColor(GAME.playerList.get(1).color);
            g.fillRect(460 + GUI.height - 70, PONG.yp2, 20, 100);
            g.setColor(GAME.playerList.get(2).color);
            g.fillRect(PONG.xp1, 90, 100, 20);
            g.setColor(GAME.playerList.get(3).color);
            g.fillRect(PONG.xp2, 40 + GUI.height - 70, 100, 20);
            
        }
        repaint();
    }
}
