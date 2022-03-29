import java.awt.*;
import java.io.*;
import java.util.*;

public class STORAGE {
    
    static File storageFile = new File("rcs/storage.txt");
    static ArrayList<String> data = new ArrayList<>();
    
    
    
    static void save(){
        System.out.println("saving");
        data.clear();

        for (int i = 0; i < GAME.playerList.size(); i++) {
            data.add(GAME.playerList.get(i).name);
            data.add(String.valueOf(GAME.playerList.get(i).color.getRed()));
            data.add(String.valueOf(GAME.playerList.get(i).color.getGreen()));
            data.add(String.valueOf(GAME.playerList.get(i).color.getBlue()));
            data.add(String.valueOf(GAME.playerList.get(i).levelOfEncryption));
            data.add(String.valueOf(GAME.playerList.get(i).x));
            data.add(String.valueOf(GAME.playerList.get(i).y));
            data.add(" ");
        }

        try{
            FileWriter writer = new FileWriter(storageFile);



            for (int i = 0; i < data.size(); i++) {
                if(data.get(i) != " "){
                    writer.write(data.get(i) + "\t");
                } else {
                    writer.write( "\n");
                }
            }

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("error while saving");
        }
    }

    
    static void load(){
        System.out.println("loading");
        try{
            data.clear();
            Scanner scanner = new Scanner(storageFile);
            while (scanner.hasNext()) {
                data.add(scanner.next());
            }
            scanner.close();
            GAME.playerList.clear();
            for (int i = 0; i < data.size(); i+=7) {
                GAME.playerList.add(new PLAYER(data.get(i), new Color(Integer.parseInt(data.get(i + 1)),
                Integer.parseInt(data.get(i + 2)), Integer.parseInt(data.get(i + 3))),
                Integer.parseInt(data.get(i + 4)), Integer.parseInt(data.get(i + 5)),
                Integer.parseInt(data.get(i + 6)) ) );
            }


        }
        catch (IOException e) {
            System.out.println("error while loading");
        }
    }
            
}
