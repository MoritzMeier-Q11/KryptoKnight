import java.awt.*;
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
    playerList.add(new PLAYER());
    playerList.get(0).setBounds("sees", Color.darkGray, 1, 40, 40);
    playerList.add(new PLAYER());
    playerList.get(1).setBounds("seeeees", Color.darkGray, 2, 40, 40);
    gamestate = GAMESTATE.start;
    startGame();
    STORAGE.save();
    STORAGE.load();

}




    private void startGame(){
        gui = new GUI("KryptoKnight");
        imageloader = new IMAGELOADER();

    }

    private void endGame(){

        }

}
