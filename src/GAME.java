package src;

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
        playerList.add(new PLAYER("player1", Color.darkGray, 1, 40, 40));
        playerList.add(new PLAYER("player2", Color.lightGray, 2, 90, 90));
        gamestate = GAMESTATE.start;
        //STORAGE.save();
        STORAGE.load();
        startGame();
        AUDIOPLAYER.Start();
        ANIMATION.playAnimation();
        
        }

    private void startGame(){
        gui = new GUI("KryptoKnight");
        imageloader = new IMAGELOADER();
        
        }
    
    public static void startAudio()
    {
        new AUDIOPLAYER();
        AUDIOPLAYER.Start();
    }
    
    public static void startAnimation()
    {
        new ANIMATION();
        ANIMATION.playAnimation();
    }
    
    private void endGame(){

        }

}
