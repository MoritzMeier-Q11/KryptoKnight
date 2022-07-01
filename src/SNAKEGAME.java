import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Timer;

public class SNAKEGAME {
    public static JPanel panel;
    public static KeyListener keyListener;
    static JLabel win;
    static DRAWSNAKE drawsnake;
    static ArrayList<SNAKE> snakes;
    static ArrayList<APPLE> apples;
    static int[][] spawns;
    static int[][] matrix;
    static int playerCount;

    public SNAKEGAME() {

        panel = new JPanel();
        panel.setVisible(true);
        panel.requestFocus();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, GUI.width, GUI.height);

        win = new JLabel("SpielerX hat gewonnen", SwingConstants.CENTER);
        win.setBounds(GUI.width/2 - 500, 300, 1000, 100);
        win.setForeground(Color.RED);
        win.setBackground(Color.BLACK);
        win.setOpaque(true);
        win.setVisible(false);
        win.setFont(new Font("Arial", Font.BOLD, 70));
        panel.add(win);

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
        matrix = new int[64][36];
        spawns = new int[][] {{5, 30}, {5, 5}, {58, 5}, {58, 30}};
        snakes = new ArrayList<>();
        apples = new ArrayList<>();
        playerCount = 0;
        win.setVisible(false);

        for (int[] ints : matrix) {
            Arrays.fill(ints, -1);
        }
        if(GAME.playerList.size() <= 4) {
            GUI.removePanel();
            GUI.addPanel(panel, keyListener);
            for(PLAYER ignored : GAME.playerList) {
                snakes.add(new SNAKE(spawns[snakes.size()][0], spawns[snakes.size()][1], snakes.size()));
            }
            playerCount = GAME.playerList.size();
            for (int i = 0; i < 4; i++) {
                for(SNAKE s : snakes) {
                    s.addTale();
                }
            }
            for (int i = 0; i < 5; i++) {
                SpawnApple();
            }
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    for(SNAKE s : snakes) {
                        s.move();
                    }
                    for (int[] ints : matrix) {
                        Arrays.fill(ints, -1);
                    }
                    for (APPLE a : apples) {
                        matrix[a.x][a.y] = 100;
                    }
                    for(SNAKE s : snakes) {
                        if(s.alive) {
                            for (int[] c: s.coods) {
                                matrix[c[0]][c[1]] = snakes.indexOf(s)*2+1;
                            }
                        }
                    }
                    drawsnake.refresh();
                    if (playerCount <= 1) {
                        timer.cancel();
                        SNAKE winner = null;
                        for(SNAKE s : snakes) {
                            if(s.alive) {
                                if (winner == null || s.coods.size() > winner.coods.size()) {
                                    winner = s;
                                }
                            }
                        }
                        win.setText(GAME.playerList.get(snakes.indexOf(winner)).name + " hat gewonnen");
                        win.setVisible(true);
                        EndSnake();
                    }
                }
            }, 200, 100);
            //EndSnake();
        }
    }

    public static void SpawnApple() {
        Random random = new Random();
        while(true) {
            int x = random.nextInt(0, 64);
            int y = random.nextInt(0, 36);
            if(matrix[x][y] == -1) {
                apples.add(new APPLE(x, y));
                break;
            }
        }
    }

    public static void EndSnake() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                GUI.removePanel();
                GUI.addPanel(BOARD.panel, BOARD.keyListener);
            }
        }, 3000);

    }
}
