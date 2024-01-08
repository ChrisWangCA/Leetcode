class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int slow = 0;
        for(int i=0;i<s1.length;i++){
            if(s1[i] != '#'){
                s1[slow++] = s1[i];
            }else{
                slow = Math.max(slow-1,0);
            }
        }
        String s2 = new String(s1,0,slow);
        slow = 0;
        for(int i=0;i<t1.length;i++){
            if(t1[i] != '#'){
                t1[slow++] = t1[i];
            }else{
                slow = Math.max(slow-1,0);
            }
        }
        String t2 = new String(t1,0,slow);
        return s2.equals(t2);
    }
}