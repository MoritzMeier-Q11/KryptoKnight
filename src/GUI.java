import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame mainFrame;
    private DRAW draw;
    public static int width = 1200;
    public static int height = 900;
    private static KEYLISTENER keylistener;




    public GUI(String title) {

        //------------------gameWindow----------------------------------------
        mainFrame = new JFrame(title);
        mainFrame.setSize(width, height);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(IMAGELOADER.icon);
        //jframe.getContentPane().setBackground(Color.lightGray);
        mainFrame.requestFocus();
        mainFrame.setVisible(true);
        keylistener = new KEYLISTENER();
        mainFrame.addKeyListener(keylistener);
        //--------------------------------------------------------------------



        //--------------------drawing----------------------------------------
        draw = new DRAW();
        draw.setBounds(0, 0, width, height);
        mainFrame.add(draw);
        //-------------------------------------------------------------------



        //-------------------startingScreen----------------------------------
            /*JButton startGameButton = new JButton("START");
            startGameButton.setBounds(0, 0, 200, 80);
            startGameButton.setBackground(Color.yellow);
            startGameButton.setVisible(true);
            startGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GAME.gamestate = GAMESTATE.ingame;
                }
            });
            mainFrame.add(startGameButton);

             */

        //---------------------------------------------------------------------


    }
}
