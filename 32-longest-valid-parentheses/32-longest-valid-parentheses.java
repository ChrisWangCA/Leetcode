class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.equals("")) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        int pre = 0;
        int res = 0;
        for(int i=1;i<chs.length;i++){
            if(chs[i] == ')'){
                pre = i - dp[i-1] - 1;
                if(pre >= 0 && chs[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre-1]:0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}