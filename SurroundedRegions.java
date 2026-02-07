class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i == m-1 || j==n-1) && board[i][j]=='O'){
                    dfs(i,j,board);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
        public void dfs(int row,int col,char[][] board){
            if(row<0 || col<0 || row>=board.length || col>=board[0].length || 
            board[row][col]!='O'){
                return;
            }
            board[row][col] = 'T';
            int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir : direction){
                dfs(row+dir[0],col+dir[1],board);
            }
        }
    }
