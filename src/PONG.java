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
    public static int yp1, yp2, yp3, yp4;
    public static boolean up1, down1, up2, down2, up3, down3, up4, down4;
    public static JLabel label1, label2, label3, label4, label5, label6, win;
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
                if (e.getKeyCode()==KeyEvent.VK_T)
                {
                    up3 = true;
                }
                else if (e.getKeyCode()==KeyEvent.VK_G)
                {
                    down3 = true;
                }
                if (e.getKeyCode()==KeyEvent.VK_O)
                {
                    up4 = true;
                }
                else if (e.getKeyCode()==KeyEvent.VK_L)
                {
                    down4 = true;
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
                if (e.getKeyCode()==KeyEvent.VK_T)
                {
                    up3 = false;
                }
                else if (e.getKeyCode()==KeyEvent.VK_G)
                {
                    down3 = false;
                }
                if (e.getKeyCode()==KeyEvent.VK_O)
                {
                    up4 = false;
                }
                else if (e.getKeyCode()==KeyEvent.VK_L)
                {
                    down4 = false;
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
        label3 = new JLabel("testspieler: 0", SwingConstants.RIGHT);
        label3.setBounds(410, 25, 500, 50);
        label3.setBackground(Color.BLACK);
        label3.setForeground(Color.WHITE);
        label3.setVisible(true);
        label3.setOpaque(true);
        label3.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label3);
        label4 = new JLabel("testspieler: 0", SwingConstants.LEFT);
        label4.setBounds(1010, 25, 500, 50);
        label4.setBackground(Color.BLACK);
        label4.setForeground(Color.WHITE);
        label4.setVisible(true);
        label4.setOpaque(true);
        label4.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label4);
        label5 = new JLabel("testspieler: 0", SwingConstants.RIGHT);
        label5.setBounds(410, 25, 500, 50);
        label5.setBackground(Color.BLACK);
        label5.setForeground(Color.WHITE);
        label5.setVisible(true);
        label5.setOpaque(true);
        label5.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label5);
        label6 = new JLabel("testspieler: 0", SwingConstants.LEFT);
        label6.setBounds(1010, 25, 500, 50);
        label6.setBackground(Color.BLACK);
        label6.setForeground(Color.WHITE);
        label6.setVisible(true);
        label6.setOpaque(true);
        label6.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label6);

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
        size = 30;
        if(GAME.playerList.size() <= 3){
            label1.setText(GAME.playerList.get(0).name + ": " + String.valueOf(0));
            label2.setText(GAME.playerList.get(1).name + ": " + String.valueOf(0));
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
                    if (x >= 35 && x <= 55 && y - 30 == yp1 || x >= 35 && x <= 55 && y == yp1 + 100) {
                        vy = -vy;
                    }
                    if (x >= 1835 && x <= 1855 && y - 30 == yp2 || x >= 1835 && x <= 1855 && y == yp2 + 100) {
                        vy = -vy;
                    }
                    if (x <= 70 && x > 60 && y >= yp1 - size && y <= yp1 + 100) {
                        vx = -vx;
                    }
                    if (x >= 1850 - size && x < 1860 - size && y >= yp2 - size && y <= yp2 + 100) {
                        vx = -vx;
                    }
                    if (x <= 0 && y >= 0 && y <= GUI.height - size) {
                        Reset();
                        score2++;
                        label2.setText(GAME.playerList.get(1).name + ": " + String.valueOf(score2));
                    }
                    if (x >= GUI.width - size && y >= 0 && y <= GUI.height - size) {
                        Reset();
                        x = 945;
                        y = 525;
                        vx = -2;
                        vy = 2;
                        score1++;
                        label1.setText(GAME.playerList.get(0).name + ": " + String.valueOf(score1));
                    }
                    if (y <= 0 && x >= 0 && x <= GUI.width - size || y >= GUI.height - size && x >= 0 && x <= GUI.width - size) {
                        vy = -vy;
                    }
                    if (up1 && yp1 > 0) {
                        yp1 -= 2;
                    }
                    if (down1 && yp1 < 980) {
                        yp1 += 2;
                    }
                    if (up2 && yp2 > 0) {
                        yp2 -= 2;
                    }
                    if (down2 && yp2 < 980) {
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
        } else if(GAME.playerList.size() == 4) {
            label1.setText(GAME.playerList.get(0).name + " & " + GAME.playerList.get(1).name + ": " + String.valueOf(0));
            label2.setText(GAME.playerList.get(2).name + " & " + GAME.playerList.get(3).name + ": " + String.valueOf(0));
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (score1 >= 5) {
                        win.setText("Team 1 hat gewonnen");
                        win.setVisible(true);
                        EndPong();
                        timer.cancel();
                    }
                    if (score2 >= 5) {
                        win.setText("Team 2 hat gewonnen");
                        win.setVisible(true);
                        EndPong();
                        timer.cancel();
                    }

                    x += vx;
                    y += vy;
                    if (x >= 35 && x <= 55 && y - 30 == yp1 || x >= 35 && x <= 55 && y == yp1 + 50 || x >= 35 && x <= 55 && y - 30 == yp2 || x >= 35 && x <= 55 && y == yp2 + 50) {
                        vy = -vy;
                    }
                    if (x >= 1835 && x <= 1855 && y - 30 == yp3 || x >= 1835 && x <= 1855 && y == yp3 + 50 || x >= 1835 && x <= 1855 && y - 30 == yp4 || x >= 1835 && x <= 1855 && y == yp4 + 50) {
                        vy = -vy;
                    }
                    if (x <= 70 && x > 60 && y >= yp1 - size && y <= yp1 + 50 || x <= 70 && x > 60 && y >= yp2 - size && y <= yp2 + 50) {
                        vx = -vx;
                    }
                    if (x >= 1850 - size && x < 1860 - size && y >= yp3 - size && y <= yp3 + 50 || x >= 1850 - size && x < 1860 - size && y >= yp4 - size && y <= yp4 + 50) {
                        vx = -vx;
                    }
                    if (x <= 0 && y >= 0 && y <= GUI.height - size) {
                        Reset();
                        score2++;
                        label2.setText(GAME.playerList.get(2).name + " & " + GAME.playerList.get(3).name + ": " + String.valueOf(score2));
                    }
                    if (x >= GUI.width - size && y >= 0 && y <= GUI.height - size) {
                        Reset();
                        x = 945;
                        y = 525;
                        vx = -2;
                        vy = 2;
                        score1++;
                        label1.setText(GAME.playerList.get(0).name + " & " + GAME.playerList.get(1).name + ": " + String.valueOf(score1));
                    }
                    if (y <= 0 && x >= 0 && x <= GUI.width - size || y >= GUI.height - size && x >= 0 && x <= GUI.width - size) {
                        vy = -vy;
                    }
                    if (up1 && yp1 > 0) {
                        yp1 -= 2;
                    }
                    if (down1 && yp1 < 930) {
                        yp1 += 2;
                    }
                    if (up2 && yp2 > 50) {
                        yp2 -= 2;
                    }
                    if (down2 && yp2 < 980) {
                        yp2 += 2;
                    }
                    if (up3 && yp3 > 0) {
                        yp3 -= 2;
                    }
                    if (down3 && yp3 < 930) {
                        yp3 += 2;
                    }
                    if (up4 && yp4 > 50) {
                        yp4 -= 2;
                    }
                    if (down4 && yp4 < 980) {
                        yp4 += 2;
                    }
                }
            }, 0, 2);
            Timer end = new Timer();
            end.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(score1 == score2)
                    {
                        win.setText("Unentschieden!");
                        win.setVisible(true);
                    }
                    else if(score1 > score2)
                    {
                        win.setText("Team 1 hat gewonnen");
                        win.setVisible(true);
                    }
                    else
                    {
                        win.setText("Team 2 hat gewonnen");
                        win.setVisible(true);
                    }
                    EndPong();
                    timer.cancel();
                }
            }, 300000);
        }
        else if(GAME.playerList.size() > 4) {
            label1.setText(GAME.playerList.get(0).name + ": " + String.valueOf(0));
            label2.setText(GAME.playerList.get(1).name + ": " + String.valueOf(0));
            timer = new Timer();
        }

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
