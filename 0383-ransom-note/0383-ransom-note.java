class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for(char m:magazine.toCharArray()){
            res[m - 'a'] += 1;
        }
        for(char r:ransomNote.toCharArray()){
            res[r - 'a'] -= 1;
            if(res[r - 'a'] < 0) return false;
        }
        return true;
    }
}