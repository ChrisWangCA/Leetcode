class Solution {
    public int distinctSubseqII(String s) {
        char[] chs = s.toCharArray();
        int[] record = new int[26];
        int m = 1000000007;
        int all = 1;
        for(int i=0;i<chs.length;i++){
            int newCount = all;
            all = ((all+newCount) % m - record[chs[i]-'a'] % m + m) % m;
            record[chs[i] - 'a'] = newCount;
        }
        return all-1;
    }
}