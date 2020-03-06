public class LSArray{

    private LoadShedding [] arrayList;
    private FileData fileObject;
    
    private int InsertC;
    private int opCounter;
        
    public LSArray(){
    
        this.arrayList = new LoadShedding[3000];
        this.fileObject = new FileData("./data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        
        opCounter = 0;
        InsertC = 0;
        
        this.fileIntel();
    }

    private void fileIntel(){
    
        int i = 0;
        while (fileObject.hasNextLine() && i < 3000){
        
            arrayList[i++] = fileObject.readLine(); //appending data from file into an array       
        }
    }
    
    public LoadShedding findLoadShedding(int stage, int day, int startTime){
        
        for (LoadShedding entry : arrayList){
        
            if (entry != null){
            
                this.opCounter++; //counting number of comparison operations
                
                if (entry.equals(stage, day, startTime)){
                    return entry;
                }
            }
        }
        return null;
    }
    
    public String printAreas(String stage, String day, String startTime){
    
        return this.printAreas(Integer.parseInt(stage), Integer.parseInt(day), Integer.parseInt(startTime));
    }
    
    public String printAreas(int stage, int day, int startTime){
    
        LoadShedding loadShedding = this.findLoadShedding(stage, day, startTime);
        return (loadShedding == null ? "Areas not found" : "The Areas are : " + loadShedding.getAreas()  + "\n" + "comparison" + "\n" + (this.opCounter));
    }
    
    public void printAllAreas(){
    
        for (LoadShedding entry : arrayList){
        
            if (entry != null)
                System.out.println(entry);
        }
    }
}
