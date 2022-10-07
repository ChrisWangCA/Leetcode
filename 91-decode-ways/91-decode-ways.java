class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return process(s.toCharArray(),0,memo);
    }
    
    public int process(char[] chs,int i,int[] memo){
        if(i == chs.length) return 1;
        if(chs[i] == '0') return 0;
        if(memo[i] != -1) return memo[i];
        if(chs[i] == '1'){
            int res = process(chs,i+1,memo);
            if(i+1 < chs.length){
                res += process(chs,i+2,memo);
            }
            memo[i] = res;
            return res;
        }
        if(chs[i] == '2'){
            int res = process(chs,i+1,memo);
            if(i+1 < chs.length && chs[i+1] >= '0' && chs[i+1] <= '6'){
                res += process(chs,i+2,memo);
            }
            memo[i] = res;
            return res;
        }
        int res = process(chs,i+1,memo);
        memo[i] = res;
        return res;
    }
}