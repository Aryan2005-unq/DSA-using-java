class TrieNode{
    HasMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    String word = null;
    public TrieNode();
}

class Solution {
    ArrayList<String> answer = new ArrayList<>();
    char[][] fullBoard = null;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char ch : word.length()){
                if(node.children.containsKey(ch)){
                    node = node.children.get(ch);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch,newNode);
                    node = newNode;
                }
            }
            node.word = word;

        }
        fullBoard = board;
        for(int rows=0;i<board.length;i++){
            for(int cols=0;j<board[0].length;j++){
                if(root.children.containsKey(fullBoard[rows][cols])){
                    backtracking(rows,cols,root);
                }
            }
        }
        return answer;
    }
    public void backtracking(int rows,int cols,TrieNode root){
        
    }
}
