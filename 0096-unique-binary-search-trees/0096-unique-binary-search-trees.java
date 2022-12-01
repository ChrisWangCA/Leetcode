class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if(n < 2) return 1;
        dp[0] = 1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<i+1;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}