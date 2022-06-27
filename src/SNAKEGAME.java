import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class SNAKEGAME {
    public static JPanel panel;
    public static KeyListener keyListener;
    static HashMap<Integer, Integer> snaketest;
    static SNAKE s1, s2;

    static int[][] matrix;

    public SNAKEGAME() {
        matrix = new int[64][36];

        s1 = new SNAKE(5, 5, 1);
        s2 = new SNAKE(40, 20, 3);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -1;
            }
        }

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
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_W -> s1.dir = 0;
                        case KeyEvent.VK_D -> s1.dir = 1;
                        case KeyEvent.VK_S -> s1.dir = 2;
                        case KeyEvent.VK_A -> s1.dir = 3;
                        case KeyEvent.VK_UP -> s2.dir = 0;
                        case KeyEvent.VK_RIGHT -> s2.dir = 1;
                        case KeyEvent.VK_DOWN -> s2.dir = 2;
                        case KeyEvent.VK_LEFT -> s2.dir = 3;
                    }
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
                s1.move();
                s2.move();
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = -1;
                    }
                }

                matrix[s1.x][s1.y] = 1;
                matrix[s2.x][s2.y] = 3;
            }
        }, 200, 100);
        //EndSnake();
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
