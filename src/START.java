import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class START {
    public static JPanel panel;
    public static KeyListener keyListener;
    public static JLabel[] labels;
    public static JButton[] buttons;

    public START() {
        panel = new JPanel();
        panel.requestFocus();
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

        DRAWSTART drawstart = new DRAWSTART();
        drawstart.setBounds(0, 0, GUI.width, GUI.height);
        drawstart.setVisible(true);
        panel.add(drawstart);

        JButton startButton = new JButton("Start");
        startButton.setBounds(GUI.width / 2 - 100, GUI.height / 2 + 200, 200, 60);
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.red);
        startButton.setFocusable(false);
        startButton.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.removePanel();
                GUI.addPanel(BOARD.panel, BOARD.keyListener);
            }
        });
        panel.add(startButton);


        JLabel maxPlayer = new JLabel("Maximale Anzahl an Spielern", SwingConstants.CENTER);
        maxPlayer.setBounds(GUI.width / 2 - 100, GUI.height / 2 + 160, 200, 30);
        maxPlayer.setForeground(Color.red);
        maxPlayer.setVisible(false);
        panel.add(maxPlayer);

        // Anzahl der Spieler festlegen
        JTextField jTextField = new JTextField();
        jTextField.setBounds(GUI.width / 2 - 100, GUI.height / 2 + 100, 200, 50);
        jTextField.setToolTipText("Name");
        jTextField.requestFocusInWindow();
        jTextField.setFont(new Font("Arial", Font.BOLD, 30));
        jTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (jTextField.getText().length() >= 10)
                    e.consume();
                if (e.getKeyChar() == KeyEvent.VK_ENTER && jTextField.getText().length() > 0) {
                    if (GAME.playerList.size() < 6) {
                        GAME.playerList.add(new PLAYER(jTextField.getText().replaceAll("\\s", ""), Color.green, 3, 0));
                        jTextField.setText("");
                        ShowCurrentPlayers();
                    } else {
                        maxPlayer.setVisible(true);
                    }
                }
            }
        });

        panel.add(jTextField);


        labels = new JLabel[6];
        buttons = new JButton[6];
        Icon trashIcon = new ImageIcon("rcs/trashIcon.png");
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel("", SwingConstants.CENTER);
            labels[i].setBounds(100, 300 + 75*i, 400, 50);
            labels[i].setBackground(Color.WHITE);
            labels[i].setForeground(Color.BLACK);
            labels[i].setFont(new Font("Arial", Font.BOLD, 30));
            labels[i].setOpaque(true);
            labels[i].setVisible(true);
            panel.add(labels[i]);

            buttons[i] = new JButton(trashIcon);
            buttons[i].setBounds(520, 300 + 75*i, 50, 50);
            buttons[i].setBackground(Color.red);
            buttons[i].setFocusable(false);
            buttons[i].setVisible(true);
            int fi = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!labels[fi].getText().equals("")) {
                        GAME.playerList.remove(fi);
                    }
                    ShowCurrentPlayers();
                }
            });
            panel.add(buttons[i]);
        }


        panel.setLayout(null);
        panel.setVisible(true);
    }


    public static void ShowCurrentPlayers() {
        for (JLabel label : labels) {
            label.setText("");
        }
        for (int i = 0; i < GAME.playerList.size(); i++) {
            labels[i].setText(GAME.playerList.get(i).name);
        }
    }
}
