import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class BOARD {
    public static ArrayList<ArrayList<Integer>> adjacencyList;
    public static FIELD[] fields;
    public static JPanel panel;
    public static KeyListener keyListener;
    public static Color[] colors;

    public BOARD() {
        panel = new JPanel();
        panel.setVisible(true);
        panel.requestFocus();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, GUI.width, GUI.height);


        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == 'p') {
                    PONG.PlayPong();
                } else {
                    GAME.playerList.get(0).move();
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1:
                            GAME.playerList.get(0).move();
                        break;
                    case KeyEvent.VK_2:
                        if (GAME.playerList.size() >= 1) {
                            GAME.playerList.get(1).move();
                        }
                        break;
                    case KeyEvent.VK_3:
                        if (GAME.playerList.size() >= 2) {
                            GAME.playerList.get(2).move();
                        }
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        adjacencyList = new ArrayList<>();
        for (int i = 0; i < 23; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        fields = new FIELD[20];
        colors = new Color[]{Color.green, Color.red, Color.blue, Color.yellow};

        createFields();
        createEdges();

        DRAWBOARD drawboard = new DRAWBOARD();
        drawboard.setBounds(0, 0, GUI.width, GUI.height);
        drawboard.setVisible(true);
        panel.add(drawboard);
    }

    public static void createFields(){
        fields[0] = new FIELD(740, 240, colors[new Random().nextInt(3)]);
        fields[1] = new FIELD(1810, 570, colors[new Random().nextInt(3)]);
        fields[2] = new FIELD(85, 440, colors[new Random().nextInt(3)]);
        fields[3] = new FIELD(210, 270, colors[new Random().nextInt(3)]);
        fields[4] = new FIELD(525, 160, colors[new Random().nextInt(3)]);
        fields[5] = new FIELD(930, 60, colors[new Random().nextInt(3)]);
        fields[6] = new FIELD(1220, 100, colors[new Random().nextInt(3)]);
        fields[7] = new FIELD(1840, 115, colors[new Random().nextInt(3)]);
        fields[8] = new FIELD(1500, 250, colors[new Random().nextInt(3)]);
        fields[9] = new FIELD(1710, 360, colors[new Random().nextInt(3)]);
        fields[10] = new FIELD(390, 440, colors[new Random().nextInt(3)]);
        fields[11] = new FIELD(1420, 730, Color.darkGray);                              //start Field
        fields[12] = new FIELD(1140, 1020, colors[new Random().nextInt(3)]);
        fields[13] = new FIELD(780, 1000, colors[new Random().nextInt(3)]);
        fields[14] = new FIELD(495, 1010, colors[new Random().nextInt(3)]);
        fields[15] = new FIELD(220, 960, colors[new Random().nextInt(3)]);
        fields[16] = new FIELD(155, 680, colors[new Random().nextInt(3)]);
        fields[17] = new FIELD(970, 860, colors[new Random().nextInt(3)]);
        fields[18] = new FIELD(900, 600, colors[new Random().nextInt(3)]);
        fields[19] = new FIELD(650, 480, colors[new Random().nextInt(3)]);
    }

    public static void createEdges(){
        addEdge(0, 5);
        addEdge(0, 18);
        addEdge(1, 7);
        addEdge(1, 9);
        addEdge(1, 11);
        addEdge(2, 3);
        addEdge(2, 16);
        addEdge(3, 4);
        addEdge(3, 10);
        addEdge(4, 5);
        addEdge(5, 6);
        addEdge(6, 7);
        addEdge(6, 8);
        addEdge(8, 9);
        addEdge(11, 12);
        addEdge(12, 17);
        addEdge(12, 13);
        addEdge(13, 14);
        addEdge(14, 15);
        addEdge(15, 16);
        addEdge(10, 19);
        addEdge(19, 18);
        addEdge(18, 17);
    }

    public static void addEdge(int s, int d){
        adjacencyList.get(s).add(d);
        adjacencyList.get(d).add(s);
    }

}
