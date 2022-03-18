import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KEYLISTENER implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyChar() + "--->" + e.getExtendedKeyCode());

        switch(GAME.gamestate){
            case options:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        GAME.gamestate = GAMESTATE.pause;
                        System.out.println("pause");
                        break;
                }
                break;

            case pause:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        GAME.gamestate = GAMESTATE.ingame;
                        System.out.println("ingame");
                        break;
                }
                break;

            case ingame:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        System.out.println("esc");
                        GAME.gamestate = GAMESTATE.pause;
                        System.out.println("pause");
                        break;
                }
                break;

            case start:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        GAME.gamestate = GAMESTATE.pause;
                        System.out.println("pause");
                        break;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }


}
