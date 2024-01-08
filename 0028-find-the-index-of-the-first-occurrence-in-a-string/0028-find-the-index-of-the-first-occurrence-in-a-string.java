class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        int idx = 0;
        while(haystack != null){
            if(haystack.startsWith(needle)){
                return idx;
            }
            if(haystack.length() == 1){
                haystack = null;
            }else{
                haystack = haystack.substring(1,haystack.length());
            }
            idx++;
        }
        return -1;
    }
}