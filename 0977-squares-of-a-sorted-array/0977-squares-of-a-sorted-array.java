class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int index = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                res[index--] = nums[left] * nums[left];
                left++;
            }else{
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}