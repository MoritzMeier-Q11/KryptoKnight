import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class SNAKEGAME {
    public static JPanel panel;
    public static KeyListener keyListener;

    public SNAKEGAME() {
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

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        DRAWSNAKE drawsnake = new DRAWSNAKE();
        drawsnake.setBounds(0, 0, GUI.width, GUI.height);
        drawsnake.setVisible(true);
        panel.add(drawsnake);
    }
    public static void PlaySnake() {
        GUI.removePanel();
        GUI.addPanel(panel, keyListener);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("move");
            }
        }, 1000, 100);
        EndSnake();
    }

    public static void EndSnake() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                GUI.removePanel();
                GUI.addPanel(BOARD.panel, BOARD.keyListener);
            }
        }, 3000);

    }
}
