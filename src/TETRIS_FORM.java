import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;

public class TETRIS_FORM extends JPanel {
    public static JPanel[] p;
    public static int[] mY;
    public static int[] mX;
    public static String name;
    public static int dir;
    public static Border raisedbevel;
    public static Color color;
    private static int Number, randomNum;
    public static int XMax = TETRIS_MAIN.XMax;
    public static int YMax = TETRIS_MAIN.YMax;
    public static int SIZE = TETRIS_MAIN.SIZE;
    TETRIS_STORAGE storage;

    TETRIS_FORM() {
        storage = new TETRIS_STORAGE();
        setVisible(true);
        setBackground(null);
        setBounds(0, 0, 540, 990);
        setLayout(null);
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        dir = 1;
        p = new JPanel[4];
        mY = new int[p.length];
        mX = new int[p.length];
        p[0] = new JPanel();
        p[1] = new JPanel();
        p[2] = new JPanel();
        p[3] = new JPanel();
        p[0].setSize(45, 45);
        p[1].setSize(45, 45);
        p[2].setSize(45, 45);
        p[3].setSize(45, 45);
        p[0].setBorder(raisedbevel);
        p[1].setBorder(raisedbevel);
        p[2].setBorder(raisedbevel);
        p[3].setBorder(raisedbevel);

        randomNum = (int) (Math.random() * 5 + 1);
        Number = randomNum;
        checkNumber();
        System.out.println(name);

        switch (name) {
            case "triangle":
                color = Color.MAGENTA;
                p[0].setLocation((XMax / 2) - SIZE, SIZE);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation((XMax / 2) + SIZE, SIZE);
                p[3].setLocation((XMax / 2), 0);
                break;
            case "line":
                color = Color.ORANGE;
                p[0].setLocation((XMax / 2), 0);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation(XMax / 2, SIZE + SIZE);
                p[3].setLocation(XMax / 2, SIZE + SIZE + SIZE);
                break;
            case "l":
                color = Color.BLUE;
                p[0].setLocation(XMax / 2, 0);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation(XMax / 2, SIZE + SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE + SIZE);
                break;
            case "stair":
                color = Color.RED;
                p[0].setLocation((XMax / 2) - SIZE, 0);
                p[1].setLocation(XMax / 2, 0);
                p[2].setLocation(XMax / 2, SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE);
                break;
            case "square":
                color = Color.PINK;
                p[0].setLocation(XMax / 2, 0);
                p[1].setLocation((XMax / 2) + SIZE, 0);
                p[2].setLocation(XMax / 2, SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE);
                break;
        }

        p[0].setBackground(color);
        p[1].setBackground(color);
        p[2].setBackground(color);
        p[3].setBackground(color);

        TETRIS_MAIN.GamePanel.add(p[0]);
        TETRIS_MAIN.GamePanel.add(p[1]);
        TETRIS_MAIN.GamePanel.add(p[2]);
        TETRIS_MAIN.GamePanel.add(p[3]);

    }

    public String getName() {
        return name;
    }

    public int getDir() {
        return dir;
    }

    public void changeDir() {

            if (getDir() != 4) {
                dir++;
            } else {
                dir = 1;
            }

            switch (name) {
                case "triangle":
                    color = Color.MAGENTA;
                    if (getDir() == 1) {
                        System.out.println(getDir());
                        p[0].setLocation(p[0].getX() - SIZE, p[0].getY() - SIZE);
                        p[1].setLocation(p[1].getX(), +p[1].getY());
                        p[2].setLocation(p[2].getX() + SIZE, p[2].getY() + SIZE);
                        p[3].setLocation(p[3].getX() + SIZE, p[3].getY() - SIZE);
                        break;
                    }
                    if (getDir() == 2) {
                        System.out.println(getDir());
                        p[0].setLocation(p[0].getX() + SIZE, p[0].getY() - SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() - SIZE, p[2].getY() + SIZE);
                        p[3].setLocation(p[3].getX() + SIZE, p[3].getY() + SIZE);
                        break;

                    } else if (getDir() == 3) {
                        System.out.println(getDir());
                        p[0].setLocation(p[0].getX() + SIZE, p[0].getY() + SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() - SIZE, p[2].getY() - SIZE);
                        p[3].setLocation(p[3].getX() - SIZE, p[3].getY() + SIZE);
                        break;
                    } else if (getDir() == 4) {
                        System.out.println(getDir());
                        p[0].setLocation(p[0].getX() - SIZE, p[0].getY() + SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() + SIZE, p[2].getY() - SIZE);
                        p[3].setLocation(p[3].getX() - SIZE, p[3].getY() - SIZE);
                        break;
                    }
                    break;
                case "line":
                    color = Color.ORANGE;
                    if (getDir() == 1 || getDir() == 3) {
                        p[0].setLocation(p[0].getX() + SIZE, p[0].getY() - SIZE - SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY() - SIZE);
                        p[2].setLocation(p[2].getX() - SIZE, p[2].getY());
                        p[3].setLocation(p[3].getX() - SIZE - SIZE, p[3].getY() + SIZE);
                        break;
                    } else if (getDir() == 2 || getDir() == 4) {
                        p[0].setLocation(p[0].getX() - SIZE, p[0].getY() + SIZE + SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY() + SIZE);
                        p[2].setLocation(p[2].getX() + SIZE, p[2].getY());
                        p[3].setLocation(p[3].getX() + SIZE + SIZE, p[3].getY() - SIZE);
                        break;
                    }
                    break;
                case "l":
                    color = Color.BLUE;
                    if (getDir() == 1) {
                        p[0].setLocation(p[0].getX() + SIZE, p[0].getY() - SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() - SIZE, p[2].getY() + SIZE);
                        p[3].setLocation(p[3].getX(), p[3].getY() + SIZE + SIZE);
                        break;
                    } else if (getDir() == 2) {
                        p[0].setLocation(p[0].getX() + SIZE, p[0].getY() + SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() - SIZE, p[2].getY() - SIZE);
                        p[3].setLocation(p[3].getX() - SIZE - SIZE, p[3].getY());
                        break;
                    } else if (getDir() == 3) {
                        p[0].setLocation(p[0].getX() - SIZE, p[0].getY() + SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() + SIZE, p[2].getY() - SIZE);
                        p[3].setLocation(p[3].getX(), p[3].getY() - SIZE - SIZE);
                        break;
                    } else if (getDir() == 4) {
                        p[0].setLocation(p[0].getX() - SIZE, p[0].getY() - SIZE);
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX() + SIZE, p[2].getY() + SIZE);
                        p[3].setLocation(p[3].getX() + SIZE + SIZE, p[3].getY());
                        break;
                    }
                    break;
                case "stair":
                    color = Color.RED;
                    if (getDir() == 1 || getDir() == 3) {
                        p[0].setLocation(p[0].getX() - SIZE - SIZE, p[0].getY());
                        p[1].setLocation(p[1].getX() - SIZE, p[1].getY() - SIZE);
                        p[2].setLocation(p[2].getX(), p[2].getY());
                        p[3].setLocation(p[3].getX() + SIZE, p[3].getY() - SIZE);
                        break;
                    } else if (getDir() == 2 || getDir() == 4) {
                        p[0].setLocation(p[0].getX() + SIZE + SIZE, p[0].getY());
                        p[1].setLocation(p[1].getX() + SIZE, p[1].getY() + SIZE);
                        p[2].setLocation(p[2].getX(), p[2].getY());
                        p[3].setLocation(p[3].getX() - SIZE, p[3].getY() + SIZE);
                        break;
                    }
                    break;
                case "square":
                    color = Color.PINK;
                    if (getDir() == 1 || getDir() == 2 || getDir() == 3 || getDir() == 4) {
                        p[0].setLocation(p[0].getX(), p[0].getY());
                        p[1].setLocation(p[1].getX(), p[1].getY());
                        p[2].setLocation(p[2].getX(), p[2].getY());
                        p[3].setLocation(p[3].getX(), p[3].getY());
                        break;
                    }
                    break;
            }
    }

    public static void showForm() {

        JFrame f = new JFrame();
        JPanel pa = new JPanel();
        f.setSize(740, 990);
        f.setVisible(true);
        f.setLayout(null);
        pa.setBounds(0, 0, 540, 990);
        pa.setVisible(true);
        pa.setBackground(Color.lightGray);
        pa.setLayout(null);
        pa.add(p[0]);
        pa.add(p[1]);
        pa.add(p[2]);
        pa.add(p[3]);
        f.add(pa);

    }

    public static void checkNumber() {
        if (Number == 1) {
            name = "triangle";
        } else if (Number == 2) {
            name = "line";
        } else if (Number == 3) {
            name = "l";
        } else if (Number == 4) {
            name = "square";
        } else {
            name = "stair";
        }
    }

    public static void createNewForm() {
        TETRIS_STORAGE.createStore();

        for (int j = 0; j < p.length; j++) {
            TETRIS_STORAGE.sp[j] = p[j];
        }
        p = new JPanel[p.length + 4];
        for (int i = 4; i < p.length; i++) {
            p[i] = new JPanel();
            p[i] = TETRIS_STORAGE.sp[i - 4];
        }

        p[3] = new JPanel();
        p[2] = new JPanel();
        p[1] = new JPanel();
        p[0] = new JPanel();

        randomNum = (int) (Math.random() * 5 + 1);
        Number = randomNum;
        checkNumber();
        System.out.println(name);

        switch (name) {
            case "triangle":
                color = Color.MAGENTA;
                p[0].setLocation((XMax / 2) - SIZE, SIZE);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation((XMax / 2) + SIZE, SIZE);
                p[3].setLocation((XMax / 2), 0);
                break;
            case "line":
                color = Color.ORANGE;
                p[0].setLocation((XMax / 2), 0);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation(XMax / 2, SIZE + SIZE);
                p[3].setLocation(XMax / 2, SIZE + SIZE + SIZE);
                break;
            case "l":
                color = Color.BLUE;
                p[0].setLocation(XMax / 2, 0);
                p[1].setLocation(XMax / 2, SIZE);
                p[2].setLocation(XMax / 2, SIZE + SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE + SIZE);
                break;
            case "stair":
                color = Color.RED;
                p[0].setLocation((XMax / 2) - SIZE, 0);
                p[1].setLocation(XMax / 2, 0);
                p[2].setLocation(XMax / 2, SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE);
                break;
            case "square":
                color = Color.PINK;
                p[0].setLocation(XMax / 2, 0);
                p[1].setLocation((XMax / 2) + SIZE, 0);
                p[2].setLocation(XMax / 2, SIZE);
                p[3].setLocation((XMax / 2) + SIZE, SIZE);
                break;
        }

        p[0].setSize(45, 45);
        p[1].setSize(45, 45);
        p[2].setSize(45, 45);
        p[3].setSize(45, 45);
        p[0].setBorder(raisedbevel);
        p[1].setBorder(raisedbevel);
        p[2].setBorder(raisedbevel);
        p[3].setBorder(raisedbevel);
        p[0].setBackground(color);
        p[1].setBackground(color);
        p[2].setBackground(color);
        p[3].setBackground(color);

        TETRIS_MAIN.GamePanel.add(p[0]);
        TETRIS_MAIN.GamePanel.add(p[1]);
        TETRIS_MAIN.GamePanel.add(p[2]);
        TETRIS_MAIN.GamePanel.add(p[3]);
    }

    public static void checkCollapse() {

        if (p.length != 4) {
            for (int i = 4; i < p.length; i++) {
                if (
                        (p[0].getY() == YMax - SIZE || p[1].getY() == YMax - SIZE || p[2].getY() == YMax - SIZE || p[3].getY() == YMax - SIZE ||

                                (p[0].getY() == p[i].getY() - SIZE && p[0].getX() == p[i].getX()) ||

                                (p[1].getY() == p[i].getY() - SIZE && p[1].getX() == p[i].getX()) ||

                                (p[2].getY() == p[i].getY() - SIZE && p[2].getX() == p[i].getX()) ||

                                (p[3].getY() == p[i].getY() - SIZE && p[3].getX() == p[i].getX()) &&

                                p[i].getBackground() != Color.darkGray)
                )

                 {
                    System.out.println("collapsed");
                    if (p[0].getY() == SIZE || p[1].getY() == SIZE || p[2].getY() == SIZE || p[3].getY() == SIZE) {
                        TETRIS_MAIN.gameOver();
                        TETRIS_CONTROLLER.playing = false;
                    }
                    TETRIS_MAIN.SCORE = TETRIS_MAIN.SCORE + 10;
                    TETRIS_MAIN.ScoreLabel.setText("Score: " + TETRIS_MAIN.SCORE);
                    storeRows();
                    deleteRows();
                    createNewForm();
                }
            }
        } else if (
                p[0].getY() == YMax - SIZE || p[1].getY() == YMax - SIZE ||
                        p[2].getY() == YMax - SIZE || p[3].getY() == YMax - SIZE) {
            System.out.println("collapsed");
            storeRows();
            deleteRows();
            createNewForm();
        }


    }

    public static void storeRows() {
        mX = new int[p.length];
        mY = new int[p.length];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                TETRIS_STORAGE.panelMatrix[j][i] = 0;
            }
        }
        for (int i = 0; i < p.length; i++) {
                mY[i] = (p[i].getY() / SIZE);
                mX[i] = (p[i].getX() / SIZE);
            TETRIS_STORAGE.panelMatrix[mY[i]][mX[i]] = 1;
        }
        Arrays.stream(TETRIS_STORAGE.panelMatrix).map(Arrays::toString).forEach(System.out::println);
        System.out.println("-----------------------------------");
    }

    public static void deleteRows(){
        for (int i = 0; i < 22; i++) {
            if (TETRIS_STORAGE.panelMatrix[i][0] == 1 && TETRIS_STORAGE.panelMatrix[i][1] == 1 &&                  //nach vollen reihen suchen = i
                    TETRIS_STORAGE.panelMatrix[i][2] == 1 && TETRIS_STORAGE.panelMatrix[i][3] == 1 &&
                    TETRIS_STORAGE.panelMatrix[i][4] == 1 && TETRIS_STORAGE.panelMatrix[i][5] == 1 &&
                    TETRIS_STORAGE.panelMatrix[i][6] == 1 && TETRIS_STORAGE.panelMatrix[i][7] == 1 &&
                    TETRIS_STORAGE.panelMatrix[i][8] == 1 && TETRIS_STORAGE.panelMatrix[i][9] == 1 &&
                    TETRIS_STORAGE.panelMatrix[i][10] == 1 && TETRIS_STORAGE.panelMatrix[i][11] == 1 )
            {
                System.out.println("row!");
                TETRIS_MAIN.LEVEL++;
                TETRIS_MAIN.LevelLabel.setText("Lines: " + TETRIS_MAIN.LEVEL);
                TETRIS_MAIN.SCORE = TETRIS_MAIN.SCORE + 1000;
                TETRIS_MAIN.ScoreLabel.setText("Score: " + TETRIS_MAIN.SCORE);


                TETRIS_STORAGE.createGravityStore();
                for (int j = 0; j < p.length; j++) {                                    //alle die nicht über der Reihe sind, grau färben
                    if (p[j].getY() <= i * SIZE){                                       //Speicher erstellen und für jedes feld das nicht in der Reihe ist 1 eintragen in Storage
                        TETRIS_STORAGE.gravityBlocks[j] = 1;
                    }
                }
                for (int j = 0; j < TETRIS_STORAGE.gravityBlocks.length; j++) {
                    System.out.println(TETRIS_STORAGE.gravityBlocks[j]);
                }

                for (int j = 0; j < p.length; j++) {                                                // blöcke zu der vollen reihe suchen
                    if (p[j].getY() == i * SIZE) {
                        p[j].setBackground(Color.darkGray);                                         //diese blöcke verschieben und färben
                        p[j].setVisible(false);
                        p[j].setLocation(XMax - SIZE, 0);
                    }
                }

                for (int l = 0; l < TETRIS_STORAGE.gravityBlocks.length; l++) {                //Storage auslesen
                    if (TETRIS_STORAGE.gravityBlocks[l] == 1){
                        p[l].setLocation(p[l].getX(), p[l].getY()  + SIZE);          //ausgelesenen Felder verschieben

                    }
                }
            }
        }
        storeRows();

    }









}
