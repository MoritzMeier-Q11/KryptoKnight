
import java.awt.*;
import java.util.ArrayList;

public class GAME {
    public static ArrayList<PLAYER> playerList;

    public GAME() {
        GUI.addPanel(START.panel, START.keyListener);
        playerList = new ArrayList<>();
        STORAGE.load();
        START.ShowCurrentPlayers();
        //AUDIOPLAYER.Start();
        //ANIMATION.playAnimation();
        //playerList.add(new PLAYER("Severin", Color.black, 3, 11));
        //playerList.add(new PLAYER("Moritz", Color.orange, 3, 12));
    }


}
