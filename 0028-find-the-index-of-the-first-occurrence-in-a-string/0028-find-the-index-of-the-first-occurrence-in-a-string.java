class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int res = 0;
        while(haystack != null){
            if(haystack.startsWith(needle)){
                return res;
            }
            if(haystack.length() != 1){
                haystack = haystack.substring(1,haystack.length());
            }else{
                haystack = null;
            }
            res++;
        }
        return -1;
    }
}