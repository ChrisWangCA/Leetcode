class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals("")) return false;
        int len = s.length();
        s = " " + s;
        char[] chs = s.toCharArray();
        int[] next = new int[len+1];
        for(int j=0,i=2;i<chs.length;i++){
            while(j > 0 && chs[i] != chs[j + 1]){
                j = next[j];
            }
            if(chs[i] == chs[j + 1]){
                j++;
            }
            next[i] = j;
        }
        if(next[len] > 0 && len % (len - next[len]) == 0) return true;
        return false;
    }
}