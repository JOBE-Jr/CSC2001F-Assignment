// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>{

   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   public BinaryTreeNode ( dataType data, BinaryTreeNode<dataType> left, BinaryTreeNode<dataType> right )
   {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   BinaryTreeNode<dataType> getLeft(){ 
      return left;
   }
   
   BinaryTreeNode<dataType> getRight(){
      return right;
   }
}