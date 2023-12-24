class Solution {
    public List<Integer> findAnagrams(String s, String p) {
            int step = 0;
            char[] chp = p.toCharArray();
            Arrays.sort(chp);
            String s1 = new String(chp);
            int len = chp.length;
            int idx = step + len;
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<=s.length()-len;i++){
                String temp = s.substring(step,idx);
                char[] c = temp.toCharArray();
                Arrays.sort(c);
                String s2 = new String(c);
                step++;
                idx++;
                if(s1.equals(s2)){
                    res.add(i);
                }
            }
            return res;
    }
}