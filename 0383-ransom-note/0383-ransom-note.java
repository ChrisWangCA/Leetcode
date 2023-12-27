class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for(char chs:magazine.toCharArray()){
            res[chs-'a'] += 1;
        }
        for(char cht:ransomNote.toCharArray()){
            res[cht-'a'] -= 1;
            if(res[cht-'a'] < 0) return false;
        }
        return true;
    }
}