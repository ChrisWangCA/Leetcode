class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int N = coins.length;
        int[][] dp = new int[N+1][amount+1];
        for(int col = 1;col<=amount;col++){
            dp[N][col] = -1;
        }
        for(int index=N-1;index>=0;index--){
            for(int rest=0;rest<=amount;rest++){
                dp[index][rest] = -1;
                if(dp[index+1][rest] != -1){
                    dp[index][rest] = dp[index+1][rest];
                }
                if(rest-coins[index]>=0 && dp[index][rest-coins[index]] != -1){
                    if(dp[index][rest] == -1){
                        dp[index][rest] = dp[index][rest-coins[index]]+1;
                    }else{
                        dp[index][rest]=Math.min(dp[index][rest],dp[index][rest-coins[index]]+1);
                    }
                }
            }
        }
        return dp[0][amount];
    }
}