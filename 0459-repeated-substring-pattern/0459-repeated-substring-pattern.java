class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,(s+s).length()-1).contains(s);
    }
}