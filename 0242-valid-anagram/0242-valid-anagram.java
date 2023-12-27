class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(char chs:s.toCharArray()){
            res[chs-'a']+=1;
        }
        for(char cht:t.toCharArray()){
            res[cht-'a']-=1;
        }
        for(int i:res){
            if(i!=0) return false;
        }
        return true;
    }
}