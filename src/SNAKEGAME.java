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
    static DRAWSNAKE drawsnake;
    static SNAKE s1, s2;
    static ArrayList<SNAKE> snakes;
    static int[][] spawns;
    static int[][] matrix;

    public SNAKEGAME() {
        matrix = new int[64][36];
        spawns = new int[][] {{5, 30}, {5, 5}, {58, 5}, {58, 30}};
        snakes = new ArrayList<>();

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
                        //player 1
                        case KeyEvent.VK_W -> snakes.get(0).dir = 0;
                        case KeyEvent.VK_D -> snakes.get(0).dir = 1;
                        case KeyEvent.VK_S -> snakes.get(0).dir = 2;
                        case KeyEvent.VK_A -> snakes.get(0).dir = 3;
                        //player 2
                        case KeyEvent.VK_UP -> snakes.get(1).dir = 0;
                        case KeyEvent.VK_RIGHT -> snakes.get(1).dir = 1;
                        case KeyEvent.VK_DOWN -> snakes.get(1).dir = 2;
                        case KeyEvent.VK_LEFT -> snakes.get(1).dir = 3;
                        //player 3
                        case KeyEvent.VK_I -> snakes.get(2).dir = 0;
                        case KeyEvent.VK_L -> snakes.get(2).dir = 1;
                        case KeyEvent.VK_K -> snakes.get(2).dir = 2;
                        case KeyEvent.VK_J -> snakes.get(2).dir = 3;
                        //player 4
                        case KeyEvent.VK_T -> snakes.get(3).dir = 0;
                        case KeyEvent.VK_H -> snakes.get(3).dir = 1;
                        case KeyEvent.VK_G -> snakes.get(3).dir = 2;
                        case KeyEvent.VK_F -> snakes.get(3).dir = 3;
                    }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        drawsnake = new DRAWSNAKE();
        drawsnake.setBounds(0, 0, GUI.width, GUI.height);
        drawsnake.setVisible(true);
        panel.add(drawsnake);
    }
    public static void PlaySnake() {
        if(GAME.playerList.size() <= 4) {
            GUI.removePanel();
            GUI.addPanel(panel, keyListener);
            for(PLAYER p : GAME.playerList) {
                snakes.add(new SNAKE(spawns[snakes.size()][0], spawns[snakes.size()][1], snakes.size()));
            }
            for (int i = 0; i < 8; i++) {
                for(SNAKE s : snakes) {
                    s.addTale();
                }
            }
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    for(SNAKE s : snakes) {
                        s.move();
                    }
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            matrix[i][j] = -1;
                        }
                    }
                    for(SNAKE s : snakes) {
                        if(s.coods != null) {
                            for (int[] c: s.coods) {
                                matrix[c[0]][c[1]] = snakes.indexOf(s)*2+1;
                            }
                        }
                    }
                    drawsnake.refresh();
                }
            }, 200, 100);
            //EndSnake();
        }
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
