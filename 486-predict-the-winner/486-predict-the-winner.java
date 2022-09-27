class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return play(nums,0,nums.length-1) >= 0;
    }
    public int play(int[] nums,int left,int right){
        if(left>right) return 0;
        int planA = nums[left] - play(nums,left+1,right);
        int planB = nums[right] - play(nums,left,right-1);
        return Math.max(planA,planB);
    }
}