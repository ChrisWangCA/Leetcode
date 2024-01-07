class Solution {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i+=2*k){
            if(i + k < chs.length){
                swap(chs,i,i+k-1);
                continue;
            }
            swap(chs,i,chs.length-1);
        }
        return new String(chs);
    }
    
    public void swap(char[] chs,int i,int j){
        for(;i<j;i++,j--){
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
    }
}