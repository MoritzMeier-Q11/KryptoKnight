import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Stack;

public class GUI {

    public static JFrame mf;
    public static int width, height;
    public static Stack<Component> stack;

    public GUI() {

        stack = new Stack<>();
        mf = new JFrame("KryptoKnight");
        mf.setResizable(false);
        mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mf.setLayout(null);
        mf.setLocationRelativeTo(null);
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mf.setUndecorated(true);
        mf.setVisible(true);
        mf.getContentPane().setBackground(Color.darkGray);

        width = mf.getWidth();
        height = mf.getHeight();

        mf.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                STORAGE.save();
            }

            @Override
            public void windowClosed(WindowEvent e) {


            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }

        public static void addPanel (JPanel panel, KeyListener keyListener) {
            mf.add(panel);
            mf.addKeyListener(keyListener);
            stack.push(panel);
            mf.requestFocus();
            mf.repaint();
        }

        public static void removePanel () {
            mf.remove(stack.pop());
            mf.removeKeyListener(mf.getKeyListeners()[mf.getKeyListeners().length - 1]);
            mf.repaint();
        }

        public static void removeCertainPanel (JPanel panel){
            mf.remove(panel);
            stack.remove(panel);
            mf.repaint();
        }

        public static void removeAllPanel () {
            for (Component c : stack) {
                mf.remove(c);
            }
            mf.repaint();
        }
    }
