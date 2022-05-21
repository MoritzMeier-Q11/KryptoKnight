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
                if (e.getKeyCode()==KeyEvent.VK_UP)
                {
                    System.out.println("JA");

                }
                else if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {
                    System.out.println("nein");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        DRAWPONG drawpong = new DRAWPONG();
        drawpong.setBounds(0, 0, GUI.width, GUI.height);
        drawpong.setVisible(true);
        panel.add(drawpong);

        x = 50;
        y = 50;
        vx = 2;
        vy = 2;
        size = 30;
    }

    public static void PlayPong() {
        GUI.removePanel();
        GUI.addPanel(panel, keyListener);

        x = 50;
        y = 50;
        vx = 2;
        vy = 2;
        size = 30;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                x += vx;
                y += vy;
                if(x <= 0 && y >= 0 && y <= GUI.height - size || x >= GUI.width - size && y >= 0 && y <= GUI.height - size) {
                    vx = -vx;
                }
                if(y <= 0 && x >= 0 && x <= GUI.width - size || y >= GUI.height - size && x >= 0 && x <= GUI.width - size) {
                    vy = -vy;
                }
            }
        }, 0, 2);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("ja");
                EndPong();
            }
        }, 5000000);
    }

    public static void EndPong() {
        timer.cancel();
        GUI.removePanel();
        GUI.addPanel(BOARD.panel, BOARD.keyListener);
    }

}
