class Solution {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i+=k*2){
            if(i + k < chs.length){
                reverse(chs,i,i+k-1);
                continue;
            }
            reverse(chs,i,chs.length-1);
        }
        return new String(chs);
    }
    
    public void reverse(char[] chs,int i,int j){
        for(;i<j;i++,j--){
            char temo = chs[i];
            chs[i] = chs[j];
            chs[j] = temo;
        }
    }
}