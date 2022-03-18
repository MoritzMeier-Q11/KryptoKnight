import java.util.ArrayList;

public class GAME {
    GUI gui;
    ArrayList <PLAYER> playerList;
    STORAGE storage;
    KEYLISTENER keylistener;
    BOARD board;
    CLOCK clock;
    public static GAMESTATE gamestate ;
    IMAGELOADER imageloader;


public GAME(){
    gamestate = GAMESTATE.start;
    startGame();
}




    private void startGame(){
        gui = new GUI("KryptoKnight");
        imageloader = new IMAGELOADER();
    }

    private void endGame(){

        }

}
