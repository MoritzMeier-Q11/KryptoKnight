
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
        int x = -10;
        int y = -10;
        double vx = 0;
        double vy = -2;
        double phi = Math.acos((-vx*x+vy*y)/((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)))*(Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2)))));
        double xneu = Math.round(vx*Math.cos(Math.PI - 2*phi) - vy*Math.sin(Math.PI - 2*phi));
        double yneu = Math.round(vx*Math.sin(Math.PI - 2*phi) + vy*Math.cos(Math.PI - 2*phi));
        System.out.println(phi + "   " + Math.toDegrees(phi));
        System.out.println("x: " + xneu);
        System.out.println("y: " + yneu);

    }
    public static void NextPlayer() {
        if(currentPlayer < playerList.size() - 1) {
            currentPlayer++;
        } else {
            currentPlayer = 0;
        }
    }


}
