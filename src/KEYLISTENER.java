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
                        GAME.gamestate = GAMESTATE.pause;
                        System.out.println("pause");
                        break;
                    case KeyEvent.VK_DOWN:
                        GAME.playerList.get(0).y += 10;
                        break;
                    case KeyEvent.VK_UP:
                        GAME.playerList.get(0).y -= 10;
                        break;

                    case KeyEvent.VK_RIGHT:
                        GAME.playerList.get(0).x += 10;
                        break;

                    case KeyEvent.VK_LEFT:
                        GAME.playerList.get(0).x -= 10;
                        break;

                    case KeyEvent.VK_S:
                        GAME.playerList.get(1).y += 10;
                        break;
                    case KeyEvent.VK_W:
                        GAME.playerList.get(1).y -= 10;
                        break;

                    case KeyEvent.VK_D:
                        GAME.playerList.get(1).x += 10;
                        break;

                    case KeyEvent.VK_A:
                        GAME.playerList.get(1).x -= 10;
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
