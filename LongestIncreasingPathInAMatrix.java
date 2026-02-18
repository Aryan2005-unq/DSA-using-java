class Solution {
    private static final int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans,dfs(dp,i,j,matrix));
            }
        }
        return ans;
    }
    public int dfs(int[][] dp,int i,int j,int[][] matrix){
        if(dp[i][j]!=0) return dp[i][j];
        for(int[] dir : direction){
            int x = i + dir[0] , y = j + dir[1];
            if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]>matrix[i][j]){
                dp[i][j] = Math.max(dp[i][j],dfs(dp,x,y,matrix));
            }
        }
        return ++dp[i][j];
    }
}
