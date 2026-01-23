class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] path = new int[n];
        Arrays.fill(path,0);
        path[0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    path[j] = 0;
                }else if(j>0){
                    path[j] += path[j-1];
                }
            }
        }
        return path[n-1];
    }
}
