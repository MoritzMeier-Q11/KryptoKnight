import java.awt.*;

public class JUMPYPLAYER {
    int jumpHeight;
    boolean isActive;
    boolean isJumping;
    Color color;
    int jumpCounter;
    int maxHeight;

    JUMPYPLAYER() {
        jumpHeight = 0;
        isActive = true;
        isJumping = false;
        jumpCounter = 0;
        maxHeight = 10;
    }

    public void TryJump(){
        if(!isJumping){
            isJumping = true;
            jumpCounter = maxHeight;
        }
    }

    public void Jump(){
        if(isJumping){
            jumpHeight = jumpHeight + jumpCounter;
            if (jumpCounter > -maxHeight){
                jumpCounter --;
            } else {
                isJumping = false;
            }
        }
    }
}
