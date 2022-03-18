import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IMAGELOADER {
    public static BufferedImage icon;
    public IMAGELOADER() {
        try {
            icon = ImageIO.read(new File("rcs/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("image loading error");
        }
    }
}
