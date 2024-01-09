class Solution {
    public String removeDuplicates(String s) {
        int left = 0;
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            chs[left] = chs[i];
            if(left > 0 && chs[left] == chs[left-1]){
                left--;
            }else{
                left++;
            }
        }
        return new String(chs,0,left);
    }
}