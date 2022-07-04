import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Timer;
import java.util.ArrayList;

public class JUMPYGAME {
    public static JPanel panel;
    public static KeyListener keyListener;
    static DRAWJUMPY drawjumpy;
    static ArrayList<JUMPYPLAYER> players;
    public static int playerCount;
    static boolean hurdleGenerated;
    static float hurdlePosition;
    static int hurdleHeight;
    static int rounds;
    static double multiplier;
    public static int activePlayers;
    public static Timer runtime;

    public JUMPYGAME() {

        hurdleGenerated = false;
        hurdlePosition = 0;
        hurdleHeight = 0;
        rounds = 0;
        multiplier = 0.7;
        activePlayers = 0;
        runtime = null;

        panel = new JPanel();
        panel.setVisible(true);
        panel.requestFocus();
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, GUI.width, GUI.height);


        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    //player 1
                    case KeyEvent.VK_W ->
                        players.get(0).TryJump();
                    //player 2
                    case KeyEvent.VK_UP -> {
                        if(playerCount>1){
                            players.get(1).TryJump();}
                        //player 3
                    }
                    case KeyEvent.VK_T -> {
                        if(playerCount>2){
                            players.get(2).TryJump();}
                        //player 4
                    }
                    case KeyEvent.VK_O -> {
                        if(playerCount>3){
                        players.get(3).TryJump();}
                        //player 5
                    }
                    case KeyEvent.VK_ENTER -> {
                        if(playerCount>4){
                        players.get(4).TryJump();}
                        //player 6
                    }
                    case KeyEvent.VK_SPACE -> {
                        if(playerCount>5){
                        players.get(5).TryJump();}
                    }
                    case KeyEvent.VK_ESCAPE -> JUMPYGAME.EndJumpy();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        drawjumpy = new DRAWJUMPY();
        drawjumpy.setBounds(0, 0, GUI.width, GUI.height);
        drawjumpy.setVisible(true);
        panel.add(drawjumpy);
    }
    public static void PlayJumpy() {
        clean();
        prep();
        runtime = new Timer();
        drawjumpy.refresh();
        runtime.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                GUI.removePanel();
                GUI.addPanel(panel, keyListener);

                HurdleGenerator();
                JumpCheck();
                drawjumpy.refresh();

                if (activePlayers <= 0) {
                    System.out.println("Winner is PlayerX");
                    EndJumpy();
                }
            }
        }, 50, 40);
    }

    public static void clean(){
        hurdleGenerated = false;
        hurdlePosition = 0;
        hurdleHeight = 0;
        rounds = 0;
        multiplier = 0.7;
    }

    public static void prep(){
        players = new ArrayList<>();
        for(PLAYER playerNormal : GAME.playerList) {
            JUMPYPLAYER p = new JUMPYPLAYER();
            players.add(p);
            p.color= playerNormal.color;
        }
        playerCount = GAME.playerList.size();
        activePlayers = playerCount;
    }

    public static void HurdleGenerator(){
        if (!hurdleGenerated){
            /*if(rounds%2==0) {
                multiplier+=0.1;
            }*/
            multiplier+=0.1;
            hurdleGenerated = true;
            hurdlePosition = 100;
            hurdleHeight = 15;
        }
        else if (hurdlePosition < 3){
            rounds++;
            hurdleGenerated = false;
            hurdleHeight = 0;
        }
        else {
            if (hurdlePosition-(1*multiplier)<16.6 && hurdlePosition>16.6){
                for(JUMPYPLAYER j : players) {
                //check for collision
                    if (j.jumpHeight <= hurdleHeight && j.isActive){
                        j.isActive = false;
                        activePlayers--;
                    }
                }
            }
            hurdlePosition= (float) (hurdlePosition-(1*multiplier));
        }
    }

    public static void JumpCheck()
    {
        for(JUMPYPLAYER p: players){
            if(p.isActive){
                p.Jump();
            }
        }
    }


    public static void EndJumpy() {
        runtime.cancel();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                GUI.removePanel();
                GUI.addPanel(BOARD.panel, BOARD.keyListener);
            }
        }, 300);
    }
}