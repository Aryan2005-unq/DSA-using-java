/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void recSerialize(TreeNode root ,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return ;
        }
        sb.append(root.val).append(",");
        recSerialize(root.left,sb);
        recSerialize(root.right,sb);
    
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recSerialize(root,sb);
        return sb.toString();
    }

    public TreeNode recDeserialize(List<String> string){
        if(string.get(0).equals("null")){
            string.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(string.get(0)));
        string.remove(0);
        root.left = recDeserialize(string);
        root.right = recDeserialize(string);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringArr = data.split(",");
        List<String> arrayList = new ArrayList<String>(Arrays.asList(stringArr));
        return recDeserialize(arrayList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
