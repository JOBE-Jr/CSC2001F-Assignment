import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LSAVLTApp{
    
    public static void main (String [] args){
        
        int length = args.length;
        String namefile = length == 4 ? args[3] : "./data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        
        Logger log = Logger.getLogger(LSAVLTApp.class.getName());
        FileHandler fileHandler;
        
        try{

            fileHandler = new FileHandler("./data/data.txt");
            log.addHandler(fileHandler);
            SimpleFormatter fm = new SimpleFormatter();
            fileHandler.setFormatter(fm);
            
        } 
        
        catch (IOException e){
            e.printStackTrace();
        }

        
        LSAVLT avlTree = new LSAVLT();
        
        if (length == 0){
        
            avlTree.printAllAreas();
        }
        
        else if (length == 3 || length == 4){
            log.info( avlTree.printAreas(args[0], args[1], args[2]));
        }
        
        else {
            System.out.println("Invalid arguments to main function");
        }   
    }   
}
