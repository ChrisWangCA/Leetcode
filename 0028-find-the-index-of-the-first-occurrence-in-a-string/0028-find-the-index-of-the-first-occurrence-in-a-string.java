class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()){
            return -1;
        }
        int index = 0;
        while(haystack!=null){
            if(haystack.startsWith(needle)){
                return index;
            }
            if(haystack.length() == 1){
                haystack = null;
            }else{
                haystack = haystack.substring(1,haystack.length());
            }
            index++;
        }
        return -1;
    }
}