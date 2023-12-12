class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int step = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum >= target){
                step = Math.min(step,i-slow+1);
                sum -= nums[slow++];
            }
        }
        return step == Integer.MAX_VALUE ? 0 : step;
    }
}