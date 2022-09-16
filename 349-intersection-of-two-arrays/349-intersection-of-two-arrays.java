class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[1001];
        Set<Integer> set = new HashSet<>();
        for(int i:nums1){
            res[i] = 1;
        }
        for(int j:nums2){
            if(res[j]==1){
                set.add(j);
            }
        }
        return set.stream().mapToInt(s->s).toArray();
    }
}