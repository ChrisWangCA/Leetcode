class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow;
        for(slow = 0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}