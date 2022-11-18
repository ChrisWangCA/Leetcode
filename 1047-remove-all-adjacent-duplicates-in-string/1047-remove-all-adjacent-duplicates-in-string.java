class Solution {
    public String removeDuplicates(String s) {
        char[] chs = s.toCharArray();
        int slow = 0;
        int fast = 0;
        for(int i=0;i<chs.length;i++){
            chs[slow] = chs[fast];
            if(slow > 0 && chs[slow] == chs[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(chs,0,slow);
    }
}