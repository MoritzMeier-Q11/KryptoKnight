import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class PONG {
    public static JPanel panel;
    public static KeyListener keyListener;
    public static int x, y, vx, vy, size;
    public static int yp1, yp2;
    public static boolean up1, down1, up2, down2;
    public static JLabel label1, label2;
    public static int score1, score2;
    public static Timer timer;

    public PONG() {
        panel = new JPanel();
        panel.setVisible(true);
        panel.requestFocus();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, GUI.width, GUI.height);
        //labels = new JLabel("Score1");

        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_W)
                {
                    up1 = true;
                }
                else if (e.getKeyCode()==KeyEvent.VK_S)
                {
                    down1 = true;
                }
                if (e.getKeyCode()==KeyEvent.VK_UP)
                {
                    up2 = true;
                }
                else if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    down2 = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_W)
                {
                    up1 = false;
                }
                else if (e.getKeyCode()==KeyEvent.VK_S)
                {
                    down1 = false;
                }
                if (e.getKeyCode()==KeyEvent.VK_UP)
                {
                    up2 = false;
                }
                else if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    down2 = false;
                }
            }
        };

        DRAWPONG drawpong = new DRAWPONG();
        drawpong.setBounds(0, 0, GUI.width, GUI.height);
        drawpong.setVisible(true);
        panel.add(drawpong);

        label1 = new JLabel("P1: 0" ,SwingConstants.LEFT);
        label1.setBounds(760, 25, 200, 50);
        label1.setBackground(Color.BLACK);
        label1.setForeground(Color.WHITE);
        label1.setVisible(true);
        label1.setOpaque(true);
        label1.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label1);
        label2 = new JLabel("   P2: 0",SwingConstants.LEFT);
        label2.setBounds(960, 25, 200, 50);
        label2.setBackground(Color.BLACK);
        label2.setForeground(Color.WHITE);
        label2.setVisible(true);
        label2.setOpaque(true);
        label2.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label2);

        Reset();
        size = 30;
    }

    public static void PlayPong() {
        GUI.removePanel();
        GUI.addPanel(panel, keyListener);

        Reset();
        size = 30;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                x += vx;
                y += vy;
                if(x <= 70 && y >= yp1 - size && y <= yp1 + 100){
                    vx = -vx;
                }
                if(x >= 1850 - size && y >= yp2 - size && y <= yp2 + 100){
                    vx = -vx;
                }
                if(x <= 0 && y >= 0 && y <= GUI.height - size) {
                    Reset();
                    score2++;
                    label2.setText("P2: " + String.valueOf(score2));
                }
                if(x >= GUI.width - size && y >= 0 && y <= GUI.height - size) {
                    Reset();
                    x = 1620;
                    y = 300;
                    vx = -2;
                    vy = 2;
                    score1++;
                    label1.setText("P2: " + String.valueOf(score1));
                }
                if(y <= 0 && x >= 0 && x <= GUI.width - size || y >= GUI.height - size && x >= 0 && x <= GUI.width - size) {
                    vy = -vy;
                }
                if(up1 && yp1 > 0) {
                    yp1 -= 2;
                }
                if(down1 && yp1 < 980) {
                    yp1 += 2;
                }
                if(up2 && yp2 > 0) {
                    yp2 -= 2;
                }
                if(down2 && yp2 < 980) {
                    yp2 += 2;
                }
            }
        }, 0, 2);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("ja");
                EndPong();
            }
        }, 300000);
    }

    public static void EndPong() {
        timer.cancel();
        GUI.removePanel();
        GUI.addPanel(BOARD.panel, BOARD.keyListener);
    }

    public static void Reset() {
        x = 300;
        y = 300;
        vx = 2;
        vy = 2;
    }


}
