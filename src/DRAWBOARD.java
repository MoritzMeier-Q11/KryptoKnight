import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DRAWBOARD extends JLabel {

    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(IMAGELOADER.map, 0, 0, GUI.width, GUI.height, null);
        //g.drawImage(IMAGELOADER.player, GAME.playerList.get(0).x, GAME.playerList.get(0).y, 50, 100, null);
        //g.drawImage(IMAGELOADER.startAnimation[ANIMATION.animationImageCount], 300, 150, 600, 600, null);

        g.setColor(Color.black);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(8));
        for (int i = 0; i < BOARD.adjacencyList.size(); i++) {
            for (int j = 0; j < BOARD.adjacencyList.get(i).size(); j++) {
                g.drawLine(BOARD.fields[i].x + 25, BOARD.fields[i].y + 25,
                        BOARD.fields[BOARD.adjacencyList.get(i).get(j)].x +25,
                        BOARD.fields[BOARD.adjacencyList.get(i).get(j)].y +25);
            }
        }

        for (FIELD field : BOARD.fields) {
            g.setColor(field.color);
            g.fillOval(field.x, field.y, 50, 50);
        }

        for (PLAYER player : GAME.playerList) {
            if (player != null) {
                g.setColor(player.color);
                g.drawOval(BOARD.fields[player.position].x -10, BOARD.fields[player.position].y -10, 70, 70);
            }
        }

        repaint();
    }

}
