import java.util.ArrayList;

public class GAME {
    GUI gui;
    public static ArrayList <PLAYER> playerList;
    STORAGE storage;
    KEYLISTENER keylistener;
    BOARD board;
    CLOCK clock;
    public static GAMESTATE gamestate ;
    IMAGELOADER imageloader;


public GAME(){
    playerList = new ArrayList<>();
    playerList.add(new PLAYER("sees"));
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
