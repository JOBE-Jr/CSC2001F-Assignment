import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;

public class LSBSTApp{
    
    public static void main (String [] args){
    
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

        
        LSBST binaryTree = new LSBST();
        
        int length = args.length;
        
        if (length == 0){
        
            binaryTree.printAllAreas();
        }
        
        else if (length == 3){
            log.info( binaryTree.printAreas(args[0], args[1], args[2]));
        }
        
        else {
            System.out.println("Invalid arguments to main function");
        }   
    }   
}
