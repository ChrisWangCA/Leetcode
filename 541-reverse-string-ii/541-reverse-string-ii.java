class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i+=2*k){
            if(i+k<=ch.length){
                reverse(ch,i,i+k-1);
                continue;
            }
            reverse(ch,i,ch.length-1);
        }
        return new String(ch);
    }
    private void reverse(char[] ch,int i,int j){
        for(;i<j;i++,j--){
            char temp = ch[i];
            ch[i]  = ch[j];
            ch[j] = temp;
        }
    }
}