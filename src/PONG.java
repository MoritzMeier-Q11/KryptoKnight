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
    public static JLabel label1, label2, win;
    public static int score1, score2;
    public static Timer timer;

    public PONG() {
        panel = new JPanel();
        panel.setVisible(true);
        panel.requestFocus();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, GUI.width, GUI.height);

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

        label1 = new JLabel("testspieler: 0", SwingConstants.RIGHT);
        label1.setBounds(410, 25, 500, 50);
        label1.setBackground(Color.BLACK);
        label1.setForeground(Color.WHITE);
        label1.setVisible(true);
        label1.setOpaque(true);
        label1.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label1);
        label2 = new JLabel("testspieler: 0", SwingConstants.LEFT);
        label2.setBounds(1010, 25, 500, 50);
        label2.setBackground(Color.BLACK);
        label2.setForeground(Color.WHITE);
        label2.setVisible(true);
        label2.setOpaque(true);
        label2.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label2);

        win = new JLabel("SpielerX hat gewonnen", SwingConstants.CENTER);
        win.setBounds(GUI.width/2 - 500, 300, 1000, 100);
        win.setForeground(Color.RED);
        win.setBackground(Color.BLACK);
        win.setOpaque(true);
        win.setVisible(false);
        win.setFont(new Font("Arial", Font.BOLD, 70));
        panel.add(win);


        Reset();
        size = 30;
    }

    public static void PlayPong() {
        GUI.removePanel();
        GUI.addPanel(panel, keyListener);

        Reset();
        win.setVisible(false);
        score1 = 0;
        score2 = 0;
        label1.setText(GAME.playerList.get(0).name + ": " + String.valueOf(0));
        label2.setText(GAME.playerList.get(1).name + ": " + String.valueOf(0));
        size = 30;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (score1 >= 5) {
                    win.setText(GAME.playerList.get(0).name + " hat gewonnen");
                    win.setVisible(true);
                    EndPong();
                    timer.cancel();
                }
                if (score2 >= 5) {
                    win.setText(GAME.playerList.get(1).name + " hat gewonnen");
                    win.setVisible(true);
                    EndPong();
                    timer.cancel();
                }

                x += vx;
                y += vy;
                if(x >= 35 && x <= 55 && y - 30 == yp1 || x >= 35 && x <= 55 && y == yp1 + 100 ){
                    vy = -vy;
                }
                if(x >= 1835 && x <= 1855 && y - 30 == yp2 || x >= 1835 && x <= 1855 && y == yp2 + 100 ){
                    vy = -vy;
                }
                if(x <= 70 && x > 60 && y >= yp1 - size && y <= yp1 + 100){
                    vx = -vx;
                }
                if(x >= 1850 - size && x < 1860 - size && y >= yp2 - size && y <= yp2 + 100){
                    vx = -vx;
                }
                if(x <= 0 && y >= 0 && y <= GUI.height - size) {
                    Reset();
                    score2++;
                    label2.setText(GAME.playerList.get(1).name + ": " + String.valueOf(score2));
                }
                if(x >= GUI.width - size && y >= 0 && y <= GUI.height - size) {
                    Reset();
                    x = 945;
                    y = 525;
                    vx = -2;
                    vy = 2;
                    score1++;
                    label1.setText(GAME.playerList.get(0).name + ": " +  String.valueOf(score1));
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
        Timer end = new Timer();
        end.schedule(new TimerTask() {
            @Override
            public void run() {
                win.setText("Unentschieden!");
                win.setVisible(true);
                EndPong();
                timer.cancel();
            }
        }, 300000);
    }

    public static void EndPong() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                GUI.removePanel();
                GUI.addPanel(BOARD.panel, BOARD.keyListener);
            }
        }, 3000);

    }

    public static void Reset() {
        x = 945;
        y = 525;
        vx = 2;
        vy = 2;
    }
}
