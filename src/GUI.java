import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame jframe;
    DRAW draw;
    public static int width = 1920;
    public static int height = 1080;



    public GUI(String titel) {
        jframe = new JFrame();
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);
        jframe.setLocationRelativeTo(null);
        jframe.setTitle(titel);
        jframe.setIconImage(IMAGELOADER.icon);
        //jframe.getContentPane().setBackground(Color.lightGray);

        draw = new DRAW();
        draw.setBounds(0, 0, width, height);
        jframe.add(draw);

        jframe.requestFocus();
        jframe.setVisible(true);
    }
}
