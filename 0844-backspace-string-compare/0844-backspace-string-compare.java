class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] chs = s.toCharArray();
        int slow = 0;
        for(int i=0;i<chs.length;i++){
            if(chs[i] == '#'){
                slow = Math.max(0,slow-1);
            }else{
                chs[slow++] = chs[i];
            }
        }
        String s1 = new String(chs,0,slow);
        slow = 0;
        char[] cht = t.toCharArray();
        for(int i=0;i<cht.length;i++){
            if(cht[i] == '#'){
                slow = Math.max(0,slow-1);
            }else{
                cht[slow++] = cht[i];
            }
        }
        String s2 = new String(cht,0,slow);
        return s1.equals(s2);
    }
}