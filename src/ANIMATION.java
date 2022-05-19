import java.util.*;

public class ANIMATION
{
    public static int animationImageCount;

    ANIMATION(){
    }

    public static void playAnimation() {
        Timer timer = new Timer();
        animationImageCount = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(animationImageCount < 117) {
                    animationImageCount++;
                }

            }
        }, 0, 30);
        System.out.println("Animation started");
    }
}