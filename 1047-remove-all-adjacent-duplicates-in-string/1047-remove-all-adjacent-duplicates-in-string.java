class Solution {
    public String removeDuplicates(String s) {
        int slow = 0;
        char[] chs = s.toCharArray();
        for(int fast = 0;fast<chs.length;fast++){
            chs[slow] = chs[fast];
            if(slow > 0 && chs[slow] == chs[slow-1]){
                slow--;
            }else{
                slow++;
            }
        }
        return new String(chs,0,slow);
    }
}