class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(char c:s.toCharArray()){
            res[c-'a'] += 1;
        }
        for(char c:t.toCharArray()){
            res[c-'a'] -= 1;
            if(res[c-'a'] < 0) return false;
        }
        for(int i:res){
            if(i != 0) return false;
        }
        return true;
    }
}