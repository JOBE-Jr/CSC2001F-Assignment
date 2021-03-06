// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{

    public int height ( BinaryTreeNode<dataType> node )
    {
        if (node != null)
            return node.height;
        return -1;
    }
   
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
        return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
        node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight (p);
        fixHeight (q);
        return q;
   }

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( dataType d )
   {
      root = insert (d, root);
   }

   private int insertC = 0;
    
   public void insert ( dataType d){
   
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
         
      else
         insert (d, root);
   }
   
   public void insert ( dataType d, BinaryTreeNode<dataType> node){
   
      insertC++;
      if (d.compareTo (node.data) <= 0){
      
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      
      else{
      
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   public int getInsertC(){
      return insertC;
   }
   
   public BinaryTreeNode<dataType> find(dataType d){
   
      if (root == null)
         return null;
         
      else
         return find (d, root);
   }
   
   private int opCounter = 0;
   
   public BinaryTreeNode<dataType> find(dataType d, BinaryTreeNode<dataType> node)
   {
      opCounter++;
      
      if (d.compareTo (node.data) == 0) 
         return node;
         
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
         
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public int getOpCounter(){
      return opCounter;
   }
   
   public void delete(dataType d){
   
      root = delete (d, root);
   }   
   
   public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node){
      
      if (node == null)
         return null;
         
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
         
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
         
      else if (node.left != null && node.right != null){
     
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      
      else
         if (node.left != null)
            node = node.left;
            
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node){
   
      if (node != null)
         while (node.left != null)
            node = node.left;
            
      return node;
   }

   public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node){
   
      if (node == null)
         return null;
         
      else if (node.left != null){
      
         node.left = removeMin (node.left);
         return node;
      }
      
      else
         return node.right;
   }  
}
