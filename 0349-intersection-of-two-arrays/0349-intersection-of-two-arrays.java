class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[1001];
        for(int i:nums1){
            res[i] += 1;
        }
        for(int j:nums2){
            if(res[j] != 0){
                set.add(j);
            }
        }
        return set.stream().mapToInt(s->s).toArray();
    }
}