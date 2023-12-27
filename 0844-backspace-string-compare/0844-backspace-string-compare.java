class Solution {
    public boolean backspaceCompare(String s, String t) {
        int slow = 0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for(int i=0;i<s1.length;i++){
            if(s1[i] != '#'){
                s1[slow++] = s1[i];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String r1 = new String(s1,0,slow);
        slow = 0;
        for(int i=0;i<t1.length;i++){
            if(t1[i] != '#'){
                t1[slow++] = t1[i];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String r2 = new String(t1,0,slow);
        return r1.equals(r2);
    }
}