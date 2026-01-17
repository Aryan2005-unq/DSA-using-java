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
    Map<Integer,Integer> inOrderIndex;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inOrderIndex = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderIndex.put(inorder[i],i);
        }
        return arrayToTree(preorder,0,preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder,int left, int right){
        if(left > right){
            return null;
        }
        int rootvalue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootvalue);

        root.left = arrayToTree(preorder,left,inOrderIndex.get(rootvalue)-1);
        root.right = arrayToTree(preorder,inOrderIndex.get(rootvalue)+1,right);

        return root;
    }
}
