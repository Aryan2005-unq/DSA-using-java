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
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> nums){
        if(root == null){
            return nums;
        }
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right,nums);
        return nums;
        
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = inOrder(root,new ArrayList<Integer>());
        return arr.get(k-1);
    }
}
