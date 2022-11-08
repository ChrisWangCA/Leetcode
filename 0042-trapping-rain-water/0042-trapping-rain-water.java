class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int val = 0;
        int leftVal = height[0];
        int rightVal = height[height.length-1];
        int leftIndex = 1;
        int rightIndex = height.length-2;
        while(leftIndex <= rightIndex){
            if(leftVal <= rightVal){
                val += Math.max(0,leftVal - height[leftIndex]);
                leftVal = Math.max(leftVal,height[leftIndex++]);
            }else{
                val += Math.max(0,rightVal - height[rightIndex]);
                rightVal = Math.max(rightVal,height[rightIndex--]);
            }
        }
        return val;
    }
}