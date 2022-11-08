class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return process(nums,0,nums.length-1) >=0;
    }
    
    public int process(int[] nums,int left,int right){
        if(left > right) return 0;
        int planA = nums[left] - process(nums,left+1,right);
        int planB = nums[right] - process(nums,left,right-1);
        return Math.max(planA,planB);
    }
}