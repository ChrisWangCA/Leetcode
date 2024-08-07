class Solution {
    public boolean backspaceCompare(String s, String t) {
        int slow = 0;
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i] == '#'){
                slow = Math.max(0,slow-1);
            }else{
            chs[slow++] = chs[i];
            }
        }
        String r1 = new String(chs,0,slow);
        slow = 0;
        char[] cht = t.toCharArray();
        for(int j = 0;j<cht.length;j++){
            if(cht[j] == '#'){
                slow = Math.max(0,slow-1);
            }else{
            cht[slow++] = cht[j];
            }
        }
        String r2 = new String(cht,0,slow);
        return r1.equals(r2);
    }
}