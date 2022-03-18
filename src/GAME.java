import java.util.ArrayList;

public class GAME {
    GUI gui;
    ArrayList <PLAYER> playerList;
    STORAGE storage;
    KEYLISTENER keylistener;
    BOARD board;
    CLOCK clock;
    GAMESTATE gamestate ;
    IMAGELOADER imageloader;


public GAME(){
    gamestate = GAMESTATE.start;
    imageloader = new IMAGELOADER();
    startGame();
}




    private void startGame(){
    gui = new GUI("KryptoKnight");
    }

    private void endGame(){
    gamestate = GAMESTATE.pause;
        }

}
