class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max += nums[i];
            while(max >= target){
                min = Math.min(min,i-left+1);
                max -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0:min;
    }
}