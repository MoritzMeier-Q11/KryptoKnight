import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IMAGELOADER {
    public static BufferedImage icon, map, player, apple, livAvatar;
    public static BufferedImage[] startAnimation;


    public IMAGELOADER() {
        startAnimation = new BufferedImage[119];
        try {
            icon = ImageIO.read(new File("rcs/icon.png"));
            map = ImageIO.read(new File("rcs/map.png"));
            player = ImageIO.read(new File("rcs/player.png"));
            apple = ImageIO.read(new File("rcs/apple.png"));
            livAvatar = ImageIO.read(new File("rcs/livAvatar.png"));
            //for (int i = 1; i < 118; i++) {
            //    startAnimation[i] = ImageIO.read(new File("rcs/StartAnimation/Start-" + String.valueOf(i) + ".png"));
            //}
            startAnimation[118] = icon;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image loading error");
        }
    }
}
