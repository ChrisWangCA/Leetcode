class Solution {
    public String removeDuplicates(String s) {
        char[] cha = s.toCharArray();
        int slow = 0;
        int fast = 0;
        for(;fast<cha.length;fast++){
            cha[slow] = cha[fast];
            if(slow > 0 && cha[slow] == cha[slow-1]){
                slow--;
            }else{
                slow++;
            }
        }
        return new String(cha,0,slow);
    }
}