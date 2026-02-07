class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(i,j,grid);
                }
            }
        }
        return island;
    }
    public void dfs(int row,int col,char[][] grid){
        int newrow = grid.length;
        int newcol = grid[0].length;
        
        if(row<0 || col<0 || row>=newrow || col>=newcol || grid[row][col]=='0'){
            return;
        }
        grid[row][col] = '0';
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] direction : directions){
            dfs(row+direction[0],col+direction[1],grid);
        }
    }
}
