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
    int maxSum = Integer.MIN_VALUE;
    public int maximum(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(maximum(root.left),0);
        int rightGain = Math.max(maximum(root.right),0);
        int sumSoFar = root.val + leftGain + rightGain;

        maxSum = Math.max(sumSoFar,maxSum);
        return Math.max(leftGain,rightGain) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maximum(root);
        return maxSum;
    }
}
