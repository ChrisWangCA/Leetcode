class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                int sum = i+j;
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }else{
                    map.put(sum,1);
                }
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                int sum = i+j;
                if(map.containsKey(0-sum)){
                    res += map.get(0-sum);
                }
            }
        }
        return res;
    }
}