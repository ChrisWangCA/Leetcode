class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] s1 = new int[26];
        int[] p1 = new int[26];
        if(p.length() > s.length()) return res;
        int left = 0;
        for(int i=0;i<p.length();i++){
            s1[s.charAt(i)-'a'] += 1;
            p1[p.charAt(i)-'a'] += 1;
        }
        if(Arrays.equals(s1,p1)){
            res.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            s1[s.charAt(i-p.length())-'a'] -= 1;
            s1[s.charAt(i)-'a'] += 1;
            if(Arrays.equals(s1,p1)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}