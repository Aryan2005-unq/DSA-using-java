class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        int inf = amount + 1;
        Arrays.fill(dp,inf);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i - coin >=0){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return (dp[amount] < inf) ? dp[amount] : -1;
    }
}
