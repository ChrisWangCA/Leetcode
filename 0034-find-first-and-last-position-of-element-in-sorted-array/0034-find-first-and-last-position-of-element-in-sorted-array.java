class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target);
        if(left >= nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        int right = binarySearch(nums,target+1);
        return new int[]{left,right-1};
    }
    
    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}