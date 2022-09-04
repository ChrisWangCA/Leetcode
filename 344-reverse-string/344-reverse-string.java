class Solution {
    public void reverseString(char[] s) {
        int right = s.length-1;
        for(int i=0;i<right;i++){
            char temp = s[i];
            s[i] = s[right];
            s[right] = temp;
            right--;
        }
    }
}