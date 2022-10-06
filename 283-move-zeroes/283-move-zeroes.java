class Solution {
    public void moveZeroes(int[] nums) {
        int slow;
        int fast = 0;
        for(slow = 0;fast<nums.length;fast++){
            if(nums[fast] != 0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
    }
}