class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i: nums1){
            s1.add(i);
        }
        for(int i:nums2){
            if(s1.contains(i)){
                s2.add(i);
            }
        }
        return s2.stream().mapToInt(s->s).toArray();
    }
}