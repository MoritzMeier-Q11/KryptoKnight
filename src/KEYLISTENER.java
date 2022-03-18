import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEYLISTENER implements KeyListener {
    GAMESTATE gamestate;

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(gamestate){
            case options:

            case pause:
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gamestate = GAMESTATE.ingame;
                }
                break;

            case ingame:

            case start:
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gamestate = GAMESTATE.options;
                }
                break;


        }

    }

    @Override
    public void keyReleased(KeyEvent e){

    }


}
