import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LSArrayApp{
    
    public static void main(String [] args){
        
        Logger log = Logger.getLogger(LSArrayApp.class.getName());
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
         
        LSArray arrayList = new LSArray();
        
        int length = args.length;
        
        if (length == 0){  //if te input is none then print all areas
        
            arrayList.printAllAreas();
        }
        else if (length == 3){
        
            log.info(arrayList.printAreas(args[0], args[1], args[2]));
        }
        
        else{
        
            System.out.println("Invalid arguments to main function"); // if the argument do not match the ones required then print this message
        }
    }
}
