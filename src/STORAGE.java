import java.io.*;
import java.util.*;

public class STORAGE {
    
    static File storageFile = new File("rcs/storage.txt");
    static ArrayList<String> data = new ArrayList<>();
    
    
    
    static void save(){
        for (int i = 0; i < GAME.playerList.size(); i++) {
            data.add(GAME.playerList.get(i).name);
            data.add(String.valueOf(GAME.playerList.get(i).color));
            data.add(String.valueOf(GAME.playerList.get(i).levelOfEncryption));
            data.add(String.valueOf(GAME.playerList.get(i).x));
            data.add(String.valueOf(GAME.playerList.get(i).y));
            data.add(" ");
        }

        try{
            FileWriter writer = new FileWriter(storageFile);

            for (int i = 0; i < data.size(); i++) {
                if(data.get(i) != " "){
                    Objects.requireNonNull(writer).write(data.get(i) + "\t");
                } else {
                    Objects.requireNonNull(writer).write( "\n");
                }
            }

            Objects.requireNonNull(writer).close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("error while saving");
        }
    }

    
    static void load(){
        try{
            data.clear();
            Scanner scanner = new Scanner(storageFile);
            while (scanner.hasNext()) {
                data.add(scanner.next());
            }
            scanner.close();
            System.out.println(data);
        }
        catch (IOException e) {
            System.out.println("error while loading");
        }
    }
            
}
