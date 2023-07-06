class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        while(haystack != null){
            if(haystack.startsWith(needle)){
                return i;
            }
            if(haystack.length() == 1){
                haystack = null;
            }else{
                haystack = haystack.substring(1,haystack.length());
            }
            i++;
        }
        return -1;
    }
}