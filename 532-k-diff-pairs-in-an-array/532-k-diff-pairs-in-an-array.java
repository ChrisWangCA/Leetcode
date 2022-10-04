class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(k == 0){
            for(int count:map.values()){
                if(count > 1) res++;
            }
        }else{
            for(int i:map.keySet()){
                if(map.containsKey(i+k)) res++;
            }
        }
        return res;
    }
}