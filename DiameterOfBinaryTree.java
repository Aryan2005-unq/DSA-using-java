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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return diameter;
    }
    private int maxDiameter(TreeNode root){
        if(root == null) return 0;

        int leftMax = maxDiameter(root.left);
        int rightMax = maxDiameter(root.right);

        diameter = Math.max(diameter,leftMax+rightMax);

        return Math.max(leftMax,rightMax) + 1;
    }
}
