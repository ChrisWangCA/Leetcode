class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res = 0;
        if(k == 0){
            for(Integer i:map.values()){
                if(i > 1){
                    res++;
                }
            }
        }else{
            for(Integer i:map.keySet()){
                if(map.containsKey(i+k)){
                    res++;
                }
            }
        }
        return res;
    }
}