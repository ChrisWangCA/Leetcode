class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int right = s.length-1;
        for(int i=g.length-1;i>=0;i--){
            if(right >= 0 && s[right] >= g[i]){
                res++;
                right--;
            }
        }
        return res;
    }
}