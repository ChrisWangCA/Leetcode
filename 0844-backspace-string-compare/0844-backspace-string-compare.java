class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int slow = 0;
        for(int i=0;i<c1.length;i++){
            if(c1[i] != '#'){
                c1[slow++] = c1[i];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String s1 = new String(c1,0,slow);
        slow = 0;
        for(int i=0;i<c2.length;i++){
            if(c2[i] != '#'){
                c2[slow++] = c2[i];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String s2 = new String(c2,0,slow);
        return s1.equals(s2);
    }
}