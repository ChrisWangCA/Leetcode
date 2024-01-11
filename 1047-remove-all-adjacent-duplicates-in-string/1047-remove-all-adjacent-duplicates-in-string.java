class Solution {
    public String removeDuplicates(String s) {
        int slow = 0;
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            chs[slow] = chs[i];
            if(slow > 0 && chs[slow] == chs[slow-1]){
                slow--;
            }else{
                slow++;
            }
        }
        return new String(chs,0,slow);
    }
}