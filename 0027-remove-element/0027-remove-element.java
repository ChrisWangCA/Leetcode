class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0;fast<nums.length;fast++){
            nums[slow] = nums[fast];
            if(nums[fast] != val) slow++;
        }
        return slow;
    }
}