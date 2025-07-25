
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        
        if(Math.abs(leftheight - rightheight) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return 1+ Math.max(height(root.left),height(root.right));
        }
    }
}
