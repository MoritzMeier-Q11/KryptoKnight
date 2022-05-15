package src;

import javax.swing.*;
import java.util.Arrays;

    public class TETRIS_STORAGE extends JPanel {
    public static JPanel[] sp;
    public static int[][] panelMatrix;
    public static int[] gravityBlocks;

    TETRIS_STORAGE() {
        panelMatrix = new int[][]{
               //0            //5            //10
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},   //0
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},   //5
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},   //10
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},   //15
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},   //20
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Arrays.stream(panelMatrix).map(Arrays::toString).forEach(System.out::println);


    }

    public static void createStore(){
        sp = new JPanel[TETRIS_FORM.p.length + 4];
        for (int i = 0; i < TETRIS_FORM.p.length; i++) {
            sp[i] = new JPanel();
        }
    }

    public static void createGravityStore(){
        gravityBlocks = new int[TETRIS_FORM.p.length];
        for (int i = 0; i < TETRIS_FORM.p.length; i++) {
            gravityBlocks[i] = 0;
        }
    }


}
