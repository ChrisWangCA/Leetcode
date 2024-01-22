class Solution {
    public int strStr(String haystack, String needle) {
        int res = 0;
        if(haystack.length() < needle.length()) return -1;
        while(haystack != null){
            if(haystack.startsWith(needle)){
                return res;
            }
            if(haystack.length() == 1){
                haystack = null;
            }else{
                haystack = haystack.substring(1,haystack.length());
            }
            res++;
        }
        return -1;
    }
}