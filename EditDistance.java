class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] first = word1.toCharArray();
        char[] second = word2.toCharArray();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = i;
        }
        for(int j=0;j<=n;j++){
            dp[j][0] = j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(first[j-1] == second[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
