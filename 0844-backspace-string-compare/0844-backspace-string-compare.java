class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] chs = s.toCharArray();
        int slow = 0;
        for(int fast=0;fast<chs.length;fast++){
            if(chs[fast] == '#'){
                slow = Math.max(0,slow-1);
            }else{
                chs[slow++] = chs[fast];
            }
        }
        String r1 = new String(chs,0,slow);
        char[] cht = t.toCharArray();
        slow = 0;
        for(int fast = 0;fast<cht.length;fast++){
            if(cht[fast] == '#'){
                slow = Math.max(0,slow-1);
            }else{
                cht[slow++] = cht[fast];
            }
        }
        String r2 = new String(cht,0,slow);
        return r1.equals(r2);
    }
}