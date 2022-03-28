import java.awt.*;

public class PLAYER {
    String name;
    Color color;
    int levelOfEncryption;
    int x, y;


    void setName(String name){
        this.name = name;
    }
    void setColor(Color color){
        this.color = color;
    }
    void setLevelOfEncryption(int levelOfEncryption){
        this.levelOfEncryption = levelOfEncryption;
    }
    void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    void setBounds(String name, Color color, int levelOfEncryption, int x, int y){
        this.name = name;
        this.color = color;
        this.levelOfEncryption = levelOfEncryption;
        this.x = x;
        this.y = y;
    }





}
