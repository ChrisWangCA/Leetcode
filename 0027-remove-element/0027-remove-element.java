class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for(;fast<nums.length;fast++){
            nums[slow] = nums[fast];
            if(nums[fast] != val){
                slow++;
            }
        }
        return slow;
    }
}