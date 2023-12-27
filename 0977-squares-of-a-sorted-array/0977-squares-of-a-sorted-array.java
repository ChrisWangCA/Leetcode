class Solution {
    public int[] sortedSquares(int[] nums) {
        int idx = nums.length-1;
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        while(left <= right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                res[idx--] = nums[left]*nums[left];
                left++;
            }else{
                res[idx--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}