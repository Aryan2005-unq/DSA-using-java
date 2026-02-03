class Solution {
    char[][] board;
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(backTrack(row,col,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backTrack(int row,int col, String word, int index){
        if(index == word.length()){
            return true;
        }
        if(row>=rows || row<0 || col>=cols || col<0 || word.charAt(index)!=board[row][col]){
            return false;
        }
        int[] row_values = {0,1,0,-1};
        int[] col_values = {1,0,-1,0};
        this.board[row][col] = '#';
        boolean ret = false;
        for(int i=0;i<4;i++){
            ret = backTrack(row+row_values[i],col+col_values[i],word,index+1);
            if(ret){
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return ret;
    }
}
