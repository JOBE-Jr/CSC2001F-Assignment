public class LoadShedding implements Comparable<LoadShedding>{

    private String slot;
    private String areas;
    private int stage;
    private int day;
    private int startTime;
    
    public LoadShedding(String slot, String areas){
    
        this.slot = slot;
        this.areas = areas;
        this.slotSeparator();
            
    }
    
    public LoadShedding (String slot){
    
        this(slot, "");
    }
    
    private void slotSeparator(){
    
        int index = this.slot.indexOf("_");
        int lastIndex = this.slot.lastIndexOf("_");
        this.stage = Integer.parseInt(this.slot.substring(0, index).trim());
        this.day = Integer.parseInt(this.slot.substring(index + 1 , lastIndex).trim());
        this.startTime = Integer.parseInt(this.slot.substring(lastIndex + 1).trim());    
    }
    
    public boolean Slot(String slot){
    
        return this.slot.equals(slot); // comparison if the slot are of the same stage, day and time
    }
    
    public boolean equals(int stage, int day, int startTime){
    
        return (stage == this.stage && day == this.day && startTime == this.startTime); //This ia a comparison of the day if it is the same as the one requested by user
    }

    public boolean Day(int day){
    
        return this.day == day; //This ia a comparison of the day if it is the same as the one requested by user
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