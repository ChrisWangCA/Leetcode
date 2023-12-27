class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int[] s1 = new int[26];
        int[] p1 = new int[26];
        for(int i=0;i<p.length();i++){
            s1[s.charAt(i) - 'a']++;
            p1[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1,p1)){
            res.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            s1[s.charAt(i)-'a']++;
            s1[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(s1,p1)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}