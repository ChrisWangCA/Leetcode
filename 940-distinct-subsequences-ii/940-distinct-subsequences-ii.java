class Solution {
    public int distinctSubseqII(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[] record = new int[26];

        int m = 1000000007;
        int all = 1;
        for(int i = 0; i < len; i++){
            int newCounts = all;
            all = ((all + newCounts) % m - record[chs[i] - 'a'] % m + m) % m;
            record[chs[i] - 'a'] = newCounts;
        }
        return all - 1;
    }
}