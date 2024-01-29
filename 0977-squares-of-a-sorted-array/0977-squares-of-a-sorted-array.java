class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length-1;
        for(int i=nums.length-1,j=0;i>=j;){
            if(nums[j] * nums[j] > nums[i] * nums[i]){
                res[index--] = nums[j] * nums[j];
                j++;
            }else{
                res[index--] = nums[i] * nums[i];
                i--;
            }
        }
        return res;
    }
}