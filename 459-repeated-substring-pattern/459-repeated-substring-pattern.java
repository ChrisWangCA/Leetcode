class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals("")){
            return false;
        }
        int size = s.length();
        s = " " + s;
        char[] ch = s.toCharArray();
        int[] next = new int[size+1];
        for(int i=2,j=0;i<=size;i++){
            while(j > 0 && ch[i]!=ch[j+1]){
                j = next[j];
            }
            if(ch[i] == ch[j+1]){
                j++;
            }
            next[i] = j;
        }
        if(next[size] > 0 && size % (size - next[size]) == 0){
            return true;
        }
        return false;
    }
}