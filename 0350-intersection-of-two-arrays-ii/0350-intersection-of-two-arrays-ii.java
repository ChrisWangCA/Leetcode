class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1001];
        for(int c:nums1){
            res[c]+=1;
        }
        for(int c:nums2){
            if(res[c] > 0){
                list.add(c);
                res[c]--;
            }
        }
        return list.stream().mapToInt(s->s).toArray();
    }
}