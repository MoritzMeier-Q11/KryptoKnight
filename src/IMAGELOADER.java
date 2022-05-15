package src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IMAGELOADER {
    public static BufferedImage icon, map, player;
    public static BufferedImage[] startAnimation;


    public IMAGELOADER() {
        startAnimation = new BufferedImage[73];
        try {
            icon = ImageIO.read(new File("rcs/icon.png"));
            map = ImageIO.read(new File("rcs/map.png"));
            player = ImageIO.read(new File("rcs/player.png"));
            for (int i = 1; i < 74; i++) {
                startAnimation[i] = ImageIO.read(new File("rcs/Start-" + String.valueOf(i) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image loading error");
        }
    }
    public static void test() {
        System.out.println("rcs/Start " + String.valueOf(1) + ".png");
    }
}
