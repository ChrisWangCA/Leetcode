class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int size = nums.length;
        while(fast < size){
            if(nums[slow] == nums[fast]){
                fast++;
            }else{
                nums[++slow] = nums[fast++];
            }
        }
        return slow+1;
    }
}