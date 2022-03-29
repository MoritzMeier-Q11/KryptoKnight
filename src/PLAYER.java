import java.awt.*;

public class PLAYER {
     String name;
     Color color;
     int levelOfEncryption;
     int x, y;

    PLAYER(String name, Color color, int levelOfEncryption, int x, int y){
        this.name = name;
        this.color = color;
        this.levelOfEncryption = levelOfEncryption;
        this.x = x;
        this.y = y;
    }
    PLAYER(){

    }

    void setBounds(String name, Color color, int levelOfEncryption, int x, int y){
        this.name = name;
        this.color = color;
        this.levelOfEncryption = levelOfEncryption;
        this.x = x;
        this.y = y;
    }


}
