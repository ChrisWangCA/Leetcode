class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[1001];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums1){
            res[i] += 1;
        }
        for(int j:nums2){
            if(res[j] > 0){
                res[j] -= 1;
                list.add(j);
            }
        }
        return list.stream().mapToInt(s->s).toArray();
    }
}