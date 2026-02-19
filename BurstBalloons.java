class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] extended = new int[n+2];
        extended[0] = 1;
        extended[n+1] = 1;
        for(int i=1;i<=n;i++){
            extended[i] = nums[i-1];
        } 
        for(int length = 1;length<=n;length++){
            for(int left=1;left<=n-length+1;left++){
                int right = left + length - 1;
                for(int i=left;i<=right;i++){
                    int coins = extended[left-1] * extended[i] * extended[right+1];
                    coins += dp[left][i-1]+dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right],coins);
                }
            }
        }
        return dp[1][n];
    }
}
