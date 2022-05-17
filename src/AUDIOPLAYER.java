package src;
 
import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Man kann nur wav Files benutzen!!!
//Bei den Methoden die was vorgegebenes abspielen wie Titelmenu im Feld nur {} eingeben
//Bei der play Methode "rcs/DATEINAME"

public class AUDIOPLAYER implements LineListener {
    
    boolean playCompleted;
    
    void play(String audioFilePath) 
    {
        
        File audioFile = new File(audioFilePath);
 
        try 
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
 
            AudioFormat format = audioStream.getFormat();
 
            DataLine.Info info = new DataLine.Info(Clip.class, format);
 
            Clip audioClip = (Clip) AudioSystem.getLine(info);
 
            audioClip.addLineListener(this);
 
            audioClip.open(audioStream);
             
            audioClip.start();
             
            while (!playCompleted) 
            {
                try 
                {
                    Thread.sleep(1000);
                }
                
                catch (InterruptedException ex) 
                {
                    ex.printStackTrace();
                }
            }
             
            audioClip.close();
             
        }
        
        catch (UnsupportedAudioFileException ex) 
        {
            System.out.println("Audiodatei nicht unterstützt");
            ex.printStackTrace();
        }
        
        catch (LineUnavailableException ex) 
        {
            System.out.println("Line ist nicht Verfügbar");
            ex.printStackTrace();
        } 
        
        catch (IOException ex) 
        {
            System.out.println("Error beim abspielen");
            ex.printStackTrace();
        }
    }

    @Override
    public void update(LineEvent event) 
    {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) 
        {
            System.out.println("Playback started.");
             
        } 
        
        else if (type == LineEvent.Type.STOP) 
        {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }
 
    public static void Titlemenu() 
    {
        String audioFilePath = "rcs/Audio/Test.wav";
        AUDIOPLAYER player = new AUDIOPLAYER();
        player.play(audioFilePath);
    }
    
    public static void Start() 
    {
        String audioFilePath = "rcs/Audio/Intro.wav";
        AUDIOPLAYER player = new AUDIOPLAYER();
        player.play(audioFilePath);
    }
    
    public static void Music() 
    {
        String audioFilePath = "rcs/Audio/Test2.wav";
        AUDIOPLAYER player = new AUDIOPLAYER();
        player.play(audioFilePath);
    }
}
