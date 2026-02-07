class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            dfs(i,0,pacific,heights);
            dfs(i,cols-1,atlantic,heights);
        }
        for(int j=0;j<cols;j++){
            dfs(0,j,pacific,heights);
            dfs(rows-1,j,atlantic,heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                   result.add(List.of(i,j)); 
                }
            }
        }
        return result;
    }
    public void dfs(int row,int col,boolean[][] reachable,int[][] heights){
        
        reachable[row][col] = true;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : directions){
            int newrow = dir[0]+row;
            int newcol = dir[1]+col;    
            if(newrow<0 || newcol<0 || newrow>=heights.length || newcol>=heights[0].length){
                continue;
            }
            if(reachable[newrow][newcol]){
                continue;
            }
            if(heights[newrow][newcol]<heights[row][col]){
                continue;
            }
            dfs(newrow,newcol,reachable,heights);
        }


    }
}
