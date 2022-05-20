import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PLAYER {
    String name;
    Color color;
    int levelOfEncryption;
    int position;
    int lastPosition;

    PLAYER(String name, Color color, int levelOfEncryption, int position){
        this.name = name;
        this.color = color;
        this.levelOfEncryption = levelOfEncryption;
        this.position = position;
        lastPosition = position;
    }

    void move() {
        ArrayList<Integer> options = new ArrayList<>();
        for (int i : BOARD.adjacencyList.get(position)) {
            if(i != lastPosition){
                for (PLAYER player : GAME.playerList) {
                    if(player.position == i) {
                                            //player überspringen fehlt noch
                    }
                }
                    options.add(i);
            }
        }
        lastPosition = position;
        position = options.get(new Random().nextInt(options.size()));
    }
}



