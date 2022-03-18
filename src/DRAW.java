import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DRAW extends JLabel {

    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        switch (GAME.gamestate){
            case start:
                    g.drawImage(IMAGELOADER.icon, 300, 150, 600, 600, null);;
                    repaint();
                    break;
            case ingame:
                    g.drawImage(IMAGELOADER.map, 300, 150, 600, 600, null);;
                    repaint();
                    break;
            case options:
                    break;
            case pause:
                    g.setColor(Color.darkGray);
                    g.drawString("PAUSE", 400, 300);
                    repaint();
                    break;
            default:
                    g.setColor(Color.darkGray);
                    g.fillRect(0, 0, GUI.width, GUI.height);
                    repaint();



        }



    }
}
