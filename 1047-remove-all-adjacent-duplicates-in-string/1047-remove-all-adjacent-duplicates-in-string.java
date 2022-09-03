class Solution {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast<s.length()){
            chars[slow] = chars[fast];
            if(slow > 0 && chars[slow] == chars[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(chars,0,slow);
    }
}