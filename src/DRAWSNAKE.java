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
        g.setColor(Color.yellow);
        for (int i = 0; i < SNAKEGAME.matrix.length; i++) {
            for (int j = 0; j < SNAKEGAME.matrix[i].length; j++) {
                if (SNAKEGAME.matrix[i][j] != -1){
                    switch (SNAKEGAME.matrix[i][j]) {
                        case 1:
                            g.setColor(GAME.playerList.get((SNAKEGAME.matrix[i][j]-1)/2).color);
                            break;
                        case 3:
                            g.setColor(GAME.playerList.get((SNAKEGAME.matrix[i][j]-1)/2).color);
                            break;
                    }
                    g.fillRect(i *30, j* 30, 30, 30);
                }
            }
        }
        repaint();
    }
}
