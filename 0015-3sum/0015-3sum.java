class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 2 || nums == null) return res;
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] > 0) return res;
            int right = nums.length-1;
            int left = i+1;
            while(right > left){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1])left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}