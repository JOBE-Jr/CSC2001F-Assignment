public class LSBST{
    
    private BinarySearchTree<LoadShedding> binaryTree;
    private FileData data;
    
    public LSBST(){
        
        binaryTree = new BinarySearchTree<LoadShedding>();
        data = new FileData("./data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        
        this.fileIntel();
    }
    
    private void fileIntel(){
        
        while(data.hasNextLine()){
            binaryTree.insert(data.readLine());
        } 
    }
    
    public LoadShedding find(LoadShedding other){
    
        BinaryTreeNode<LoadShedding> result  = binaryTree.find(other);
        return result == null ? null : result.data;
    }
    
    public LoadShedding find(String slot){
    
        return this.find(new LoadShedding(slot));
    }
    
    public String printAreas(String stage, String day, String time){
    
        return this.printAreas(stage + "_" + day + "_" + time);
    }
    
    public String printAreas(int stage, int day, int time){
    
        return this.printAreas(stage + "_" + day + "_" + time);
    }
    
    public String printAreas(String slot){
    
        LoadShedding entry = this.find(slot);
        return (entry == null ? "No Areas Found " : "The areas are: " + entry.getAreas() + "\n" + "comparison" + "\n" + (binaryTree.getOpCounter()));
    }
    
    public void printAllAreas(){
    
        binaryTree.inOrder();        
    }
}
