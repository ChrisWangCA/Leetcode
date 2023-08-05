class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                int temp = i+j;
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                int temp = i+j;
                if(map.containsKey(0 - temp)){
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}