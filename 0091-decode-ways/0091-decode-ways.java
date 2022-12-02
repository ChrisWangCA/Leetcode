class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return process(s.toCharArray(),memo,0);
    }
    public int process(char[] chs,int[] memo,int i){
        if(i == chs.length) return 1;
        if(chs[i] == '0') return 0;
        if(memo[i] != -1) return memo[i];
        if(chs[i] == '1'){
            int res = process(chs,memo,i+1);
            if(i+1 < chs.length){
                res += process(chs,memo,i+2);
            }
            memo[i] = res;
            return res;
        }
        if(chs[i] == '2'){
            int res = process(chs,memo,i+1);
            if(i+1 < chs.length && chs[i+1] >= '0' && chs[i+1] <= '6'){
                res += process(chs,memo,i+2);
            }
            memo[i] = res;
            return res;
        }
        int res = process(chs,memo,i+1);
        memo[i] = res;
        return res;
    }
}