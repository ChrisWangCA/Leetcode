class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1001];
        for(int i:nums1){
            res[i] += 1;
        }
        for(int j:nums2){
            if(res[j] > 0){
                list.add(j);
                res[j]--;
            }
        }
        return list.stream().mapToInt(s->s).toArray();
    }
}