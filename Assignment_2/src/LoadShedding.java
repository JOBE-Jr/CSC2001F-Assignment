public class LoadShedding implements Comparable<LoadShedding>{

    private String slot;
    private String areas;
    
    public LoadShedding(String slot, String areas){
    
        this.slot = slot;
        this.areas = areas;
            
    }
    
    public LoadShedding (String slot){
    
        this(slot, "");
    }
 
    public boolean equals(String stage, String day, String startTime){
    
        return ( this.slot.equals(stage + "_" + day + "_" + startTime)); //This ia a comparison of the day if it is the same as the one requested by user
    }

    public String getAreas(){ //returns areas of the requested day, stage and time
        
        return areas;
    }
    
    public String getSlot(){ //returns slot at which LoadShedding is plan to take place
    
        return this.slot;
    }
    
    public boolean equals(LoadShedding other){ // a comparison of the slots if they match with the requested one
    
        return this.slot.equals(other.getSlot());
    }
    
    public int compareTo(LoadShedding other){
    
        return this.slot.compareTo(other.getSlot());
    }
        
    public String toString(){
        return "Slot " + slot + "\n" + "Areas : " + areas;
    }
}
