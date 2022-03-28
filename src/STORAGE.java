package src;
import java.io.*;
import java.util.*;

public class STORAGE {
    
    File storageFile = new File("rcs/storage.txt");
    
    
    
    
    public void save(){
        //ArrayList<String> Data = new ArrayList<>();
        try{
            int[] data = new int[3];
            data[0] = 1;
            data[1] = 1;
            data[2] = 3;
            FileWriter writer = new FileWriter(storageFile);
        
        
        
            for (int d : data){
                Objects.requireNonNull(writer).write(d + "\n");
            }
            Objects.requireNonNull(writer).close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("error while saving");
        }
        }
        
    
    
    public void load(){
        try{
             Scanner scanner = new Scanner(storageFile);
                 while (scanner.hasNext()) {
                 System.out.println(scanner.next());
                }
            scanner.close();
        }
        catch (IOException e) {
            
        }
        }
            
    }
