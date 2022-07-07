import javax.swing.*;
import java.awt.*;

public class DRAWJUMPY extends JLabel {


    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int playerCount = GAME.playerList.size();

        //floor
        g.setColor(Color.darkGray);
        for (int i = 1; i <= playerCount; i++) {
            g.fillRect(GUI.width / 12, (GUI.height/(playerCount+2))*i + GUI.height/(playerCount+2) , (GUI.width / 12) * 10, GUI.height / 50);
        }

        //players
        int i = 1;
        for(JUMPYPLAYER p : JUMPYGAME.players){
            g.setColor(p.color);
            g.fillRect(GUI.width/6, (GUI.height/(playerCount+2))*i + GUI.height/(playerCount+2)-GUI.height / 50-p.jumpHeight, 20, 40);
            i++;
        }

        //hurdles
        g.setColor(Color.lightGray);
        i = 1;
        for(JUMPYPLAYER p: JUMPYGAME.players){
            g.fillRect((int) ((GUI.width/100)*JUMPYGAME.hurdlePosition), (GUI.height/(playerCount+2))*i + GUI.height/(playerCount+2)-GUI.height / 50, 10, 30);
            i++;
        }
    }

    public void refresh() {
        repaint();
    }
}