class Solution {
    public String removeDuplicates(String s) {
        char[] chs = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < chs.length){
            chs[slow] = chs[fast];
            if(slow > 0 && chs[slow] == chs[slow-1]){
                slow --;
            }else{
                slow ++;
            }
            fast++;
        }
        return new String(chs,0,slow);
    }
}