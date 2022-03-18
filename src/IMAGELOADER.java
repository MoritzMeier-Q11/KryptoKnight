import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IMAGELOADER {
    public static BufferedImage icon, map;



    public IMAGELOADER() {
        try {
            icon = ImageIO.read(new File("rcs/icon.png"));
            map = ImageIO.read(new File("rcs/map.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image loading error");
        }
    }
}