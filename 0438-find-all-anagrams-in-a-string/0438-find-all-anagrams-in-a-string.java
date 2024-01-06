class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int[] r1 = new int[26];
        int[] r2 = new int[26];
        for(int i=0;i<p.length();i++){
            r1[s.charAt(i) - 'a'] += 1;
            r2[p.charAt(i) - 'a'] += 1;
        }
        if(Arrays.equals(r1,r2)){
            res.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            r1[s.charAt(i) - 'a'] += 1;
            r1[s.charAt(i-p.length())-'a'] -= 1;
            if(Arrays.equals(r1,r2)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}