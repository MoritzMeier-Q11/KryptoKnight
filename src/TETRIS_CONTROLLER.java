import java.util.concurrent.TimeUnit;

public class TETRIS_CONTROLLER {

    public static final int SIZE = TETRIS_MAIN.SIZE;
    public static int XMax = TETRIS_MAIN.XMax;
    public static int YMax = TETRIS_MAIN.YMax;
    private static TETRIS_FORM form;
    public static boolean playing = true;

    TETRIS_CONTROLLER(){
        form = new TETRIS_FORM();
    }

    public static void moveRight() {
        if (playing == true && TETRIS_FORM.p[0].getX() <= XMax - SIZE - SIZE && TETRIS_FORM.p[1].getX() <= XMax - SIZE - SIZE && TETRIS_FORM.p[2].getX() <= XMax - SIZE - SIZE && TETRIS_FORM.p[3].getX() <= XMax - SIZE - SIZE) {
            TETRIS_FORM.p[0].setLocation(TETRIS_FORM.p[0].getX() + SIZE, TETRIS_FORM.p[0].getY());
            TETRIS_FORM.p[1].setLocation(TETRIS_FORM.p[1].getX() + SIZE, TETRIS_FORM.p[1].getY());
            TETRIS_FORM.p[2].setLocation(TETRIS_FORM.p[2].getX() + SIZE, TETRIS_FORM.p[2].getY());
            TETRIS_FORM.p[3].setLocation(TETRIS_FORM.p[3].getX() + SIZE, TETRIS_FORM.p[3].getY());
            form.checkCollapse();
        }
    }

    public static void moveLeft() {
        if (playing == true && TETRIS_FORM.p[0].getX() >= SIZE && TETRIS_FORM.p[1].getX() >= SIZE && TETRIS_FORM.p[2].getX() >= SIZE && TETRIS_FORM.p[3].getX() >= SIZE) {
            TETRIS_FORM.p[0].setLocation(TETRIS_FORM.p[0].getX() - SIZE, TETRIS_FORM.p[0].getY());
            TETRIS_FORM.p[1].setLocation(TETRIS_FORM.p[1].getX() - SIZE, TETRIS_FORM.p[1].getY());
            TETRIS_FORM.p[2].setLocation(TETRIS_FORM.p[2].getX() - SIZE, TETRIS_FORM.p[2].getY());
            TETRIS_FORM.p[3].setLocation(TETRIS_FORM.p[3].getX() - SIZE, TETRIS_FORM.p[3].getY());
            form.checkCollapse();
        }
    }

    public static void moveDown() {
        if (playing == true && TETRIS_FORM.p[0].getY() <= YMax - SIZE - SIZE && TETRIS_FORM.p[1].getY() <= YMax - SIZE - SIZE && TETRIS_FORM.p[2].getY() <= YMax - SIZE - SIZE && TETRIS_FORM.p[3].getY() <= YMax - SIZE - SIZE) {
            TETRIS_FORM.p[0].setLocation(TETRIS_FORM.p[0].getX() , TETRIS_FORM.p[0].getY() + SIZE);
            TETRIS_FORM.p[1].setLocation(TETRIS_FORM.p[1].getX() , TETRIS_FORM.p[1].getY() + SIZE);
            TETRIS_FORM.p[2].setLocation(TETRIS_FORM.p[2].getX() , TETRIS_FORM.p[2].getY() + SIZE);
            TETRIS_FORM.p[3].setLocation(TETRIS_FORM.p[3].getX() , TETRIS_FORM.p[3].getY() + SIZE);
            form.checkCollapse();
        }
    }

    public static void delay(int ms){
        try
        {
            TimeUnit.MILLISECONDS.sleep(ms);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void moving(){
        while (playing){
            delay(300);
            moveDown();
        }
    }







}
