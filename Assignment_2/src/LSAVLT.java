public class LSAVLT{
    
    private AVLTree<LoadShedding> avlTree;
    private FileData data;
    
    public LSAVLT(){
        
        avlTree = new AVLTree<LoadShedding>();
        data = new FileData("./data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        
        this.fileIntel();
    }
    
    private void fileIntel(){
        
        while(data.hasNextLine()){
            avlTree.insert(data.readLine());
        } 
    }
    
    public LoadShedding find(LoadShedding other){
    
        BinaryTreeNode<LoadShedding> result  = avlTree.find(other);
        return result == null ? null : result.data;
    }
    
    public LoadShedding find(String slot){
    
        return this.find(new LoadShedding(slot));
    }
    
    public String printAreas(String stage, String day, String startTime){
    
        LoadShedding entry = this.find(stage + "_" + day + "_" + startTime);

        return (entry == null ? "No Areas Found " : "The areas are: " + entry.getAreas() + "insert\tfind" +
        "\n" + (avlTree.getinsertC()) + "\n" + "comparison" + "\n" + (avlTree.getOpCounter()));
    }
    
    public void printAllAreas(){
    
        avlTree.inOrder();        
    }
}
