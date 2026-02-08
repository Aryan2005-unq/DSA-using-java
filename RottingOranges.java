class Solution {
    public int orangesRotting(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;

       Queue<int[]> rotten = new LinkedList<>();
       int freshOranges = 0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                freshOranges++;
            }else if(grid[i][j]==2){
                rotten.offer(new int[]{i,j});
            }
        }
       } 
       if(freshOranges==0){
            return 0;
        }
       int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
       int minutes = 0;
       while(!rotten.isEmpty()){
        int size = rotten.size();
        for(int i=0;i<size;i++){
            int[] rotIndex = rotten.poll();
            for(int[] dir : direction){
                int x = rotIndex[0]+dir[0];
                int y = rotIndex[1]+dir[1];
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                    grid[x][y]=2;
                    freshOranges--;
                    rotten.offer(new int[]{x,y});
                }
            }
        }
        
        minutes++;
       }
       return freshOranges==0 ? minutes-1 : -1;
    }
}
