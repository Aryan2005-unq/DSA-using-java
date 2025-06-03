class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.value = val;
        left = right = null;
    }
}

class Solution {
    TreeNode root;
    public TreeNode insert(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.value) {
            current.left = insert(current.left, value);
        } else {
            current.right = insert(current.right, value);
        }
        return current;
    }
    
    public void build(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (p < root.value && q < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p > root.value && q > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {7, 2, 9, 1, 5, 14};
        obj.build(arr);
        TreeNode LCA = obj.lowestCommonAncestor(obj.root, 1, 5);
        System.out.println("The LCA of 1 and 5 is " + LCA.value);
    }
}
