class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(char ss:s.toCharArray()){
            res[ss - 'a'] += 1;
        }
        for(char tt:t.toCharArray()){
            res[tt - 'a'] -= 1;
        }
        for(int i:res){
            if(i!=0) return false;
        }
        return true;
    }
}