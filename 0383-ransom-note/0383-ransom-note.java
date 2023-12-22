class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for(char c:magazine.toCharArray()){
            res[c-'a'] += 1;
        }
        for(char s:ransomNote.toCharArray()){
            res[s-'a'] -= 1;
            if(res[s-'a'] < 0) return false;
        }
        return true;
    }
}