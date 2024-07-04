class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = Integer.MAX_VALUE;
        int left = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max += nums[i];
            while(max >= target){
                slow = Math.min(slow,i-left+1);
                max -= nums[left++];
            }
        }
        return slow == Integer.MAX_VALUE ? 0 : slow;
    }
}