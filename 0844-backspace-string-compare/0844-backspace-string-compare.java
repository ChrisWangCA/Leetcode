class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] chs = s.toCharArray();
        int slow = 0;
        for(int fast = 0;fast < chs.length; fast++){
            if(chs[fast] != '#'){
                chs[slow++] = chs[fast];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String s1 = new String(chs,0,slow);
        char[] cht = t.toCharArray();
        slow = 0;
        for(int fast = 0; fast< cht.length;fast++){
            if(cht[fast] != '#'){
                cht[slow++] = cht[fast];
            }else{
                slow = Math.max(0,slow-1);
            }
        }
        String s2 = new String(cht,0,slow);
        return s1.equals(s2);
    }
}