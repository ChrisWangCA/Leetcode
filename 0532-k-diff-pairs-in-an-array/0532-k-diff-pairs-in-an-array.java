class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(k == 0){
            for(Integer i:map.values()){
                if(i > 1) res++;
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