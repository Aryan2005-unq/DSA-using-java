/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return maxNodes(root,Integer.MIN_VALUE);
    }
    public int maxNodes(TreeNode root,int max){
        if(root == null){
            return 0;
        }
        int count = 0;
        
        if(root.val >= max){
            count = 1;
            max = root.val;
        }
        count += maxNodes(root.left,max);
        count += maxNodes(root.right,max);
        return count;
    }
}
