
import java.awt.*;
import java.util.ArrayList;

public class GAME {
    public static ArrayList<PLAYER> playerList;
    public static int currentPlayer;

    public GAME() {
        GUI.addPanel(START.panel, START.keyListener);
        playerList = new ArrayList<>();
        STORAGE.load();
        START.ShowCurrentPlayers();
        currentPlayer = 0;
        //ANIMATION.playAnimation();
        //AUDIOPLAYER.Start();
        //playerList.add(new PLAYER("Severin", Color.black, 3, 11));
        //playerList.add(new PLAYER("Moritz", Color.orange, 3, 12));
    }
    public static void NextPlayer() {
        if(currentPlayer < playerList.size() - 1) {
            currentPlayer++;
        } else {
            currentPlayer = 0;
        }
    }


}
