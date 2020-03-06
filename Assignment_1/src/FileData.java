import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileData{
    
    File filename;
    Scanner inputReader;
    
    public FileData(String filename) {
     
        try{
        
            this.filename = new File(filename);
            this.inputReader = new Scanner(this.filename);
            
        } 
        
        catch(Exception e){
        
            System.out.println("Error Reading the filename: ");
            e.printStackTrace();   
                 
        } 
    }
    
    public boolean hasNextLine(){
    
        return inputReader.hasNextLine();
    }
    
    public LoadShedding readLine(){
     
        String l = inputReader.nextLine();
        int index = l.lastIndexOf("_") + 3; 
        String slot = (l.substring(0, index)).trim();
        String areas = (l.substring(index)).trim();
        
        return new LoadShedding(slot, areas);
    }
    
    public void setFile(String filename){
    
       this.filename = new File(filename); 
    }
    
    public String getFile(){
    
        return filename.getName();
    }
    
    public void printFile(){
    
        System.out.println("File : "+this.getFile());
        
        while( inputReader.hasNextLine()){
        
            String data = inputReader.nextLine();
            System.out.println(data);
        }
        
        inputReader.close();    
    }
    
    public String toString(){
    
        return this.getFile();
    }  
}
