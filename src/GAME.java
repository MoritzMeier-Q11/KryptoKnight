
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
        int x = 265;
        int y = 265;
        double vx = 2;
        double vy = 0;
        double phi = Math.acos((vx*x+vy*y)/((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)))*(Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2)))));
        double xneu = Math.round(vx*Math.cos(Math.PI - 2*phi) - vy*Math.sin(Math.PI - 2*phi));
        double yneu = Math.round(vx*Math.sin(Math.PI - 2*phi) + vy*Math.cos(Math.PI - 2*phi));
        System.out.println(phi + "   " + Math.toDegrees(phi));
        System.out.println("vx: " + xneu);
        System.out.println("vy: " + yneu);


    }
    public static void NextPlayer() {
        if(currentPlayer < playerList.size() - 1) {
            currentPlayer++;
        } else {
            currentPlayer = 0;
        }
    }


}
