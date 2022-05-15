package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TETRIS_MAIN {
    //public static void main(String[] args) {
      //  new TETRIS_MAIN();
    //}

    public static JFrame MainFrame;
    public static JPanel GamePanel;
    public static JLabel ScoreLabel, LevelLabel, GameOverLabel;
    public static int SCORE,  LEVEL;
    TETRIS_FORM form;
    public static int XMax;
    public static int YMax;
    public static int SIZE;

    TETRIS_MAIN() {
        SIZE = 45;
        SCORE = 0;
        XMax = 12 * SIZE;
        YMax = 22 * SIZE;

        MainFrame = new JFrame("T E T R I S");
        GamePanel = new JPanel();
        form = new TETRIS_FORM();

        MainFrame.setSize(XMax + 200, YMax + 50);
        MainFrame.setVisible(true);
        MainFrame.setResizable(false);
        MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainFrame.setLayout(null);

        GamePanel.setBounds(0, 0, XMax, YMax);
        GamePanel.setBackground(Color.lightGray);
        GamePanel.setLayout(null);
        MainFrame.add(GamePanel);

        ScoreLabel = new JLabel("Score:");
        ScoreLabel.setBounds(XMax + 10, 20, 100, 20);
        MainFrame.add(ScoreLabel);

        LevelLabel = new JLabel("Lines:");
        LevelLabel.setBounds(XMax + 10, 60, 100, 20);
        MainFrame.add(LevelLabel);

        GameOverLabel = new JLabel("Game Over");
        GameOverLabel.setBounds((XMax / 2) - 40, (YMax / 2) - 100, 70, 20);
        GameOverLabel.setVisible(false);
        GameOverLabel.setBackground(null);
        GameOverLabel.setForeground(Color.WHITE);
        GamePanel.add(GameOverLabel);

        MainFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyChar()) {

                    case 'w':
                        form.changeDir();
                        System.out.println(form.getDir());
                        break;
                    case 's':
                        TETRIS_CONTROLLER.moveDown();
                        break;
                    case 'a':
                        TETRIS_CONTROLLER.moveLeft();
                        break;
                    case 'd':
                        TETRIS_CONTROLLER.moveRight();
                        break;
                    case 'r':
                        TETRIS_CONTROLLER.playing = false;
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        TETRIS_CONTROLLER.moving();
    }

    public static void gameOver(){
        GamePanel.setForeground(Color.BLACK);
        GamePanel.setBackground(Color.BLACK);
        GameOverLabel.setVisible(true);
        TETRIS_CONTROLLER.delay(4000);
        System.exit(0);

    }


}





