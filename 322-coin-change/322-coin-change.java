class Solution {
    public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0) {
			return -1;
		}
		int N = coins.length;
		int[][] dp = new int[N + 1][amount + 1];
		// 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
		for (int col = 1; col <= amount; col++) {
			dp[N][col] = -1;
		}
		for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
			for (int rest = 0; rest <= amount; rest++) { // 每一行都从左往右
				dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
				if (dp[i + 1][rest] != -1) { // 下面的值如果有效
					dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
				}
				// 左边的位置不越界并且有效
				if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
					if (dp[i][rest] == -1) { // 如果之前下面的值无效
						dp[i][rest] = dp[i][rest - coins[i]] + 1;
					} else { // 说明下面和左边的值都有效，取最小的
						dp[i][rest] = Math.min(dp[i][rest],
								dp[i][rest - coins[i]] + 1);
					}
				}
			}
		}
		return dp[0][amount];
    }
}