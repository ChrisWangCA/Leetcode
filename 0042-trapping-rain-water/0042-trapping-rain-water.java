class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int val = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int leftIndex = 1;
        int rightIndex = height.length-2;
        while(leftIndex <= rightIndex){
            if(leftMax <= rightMax){
                val += Math.max(0,leftMax - height[leftIndex]);
                leftMax = Math.max(leftMax,height[leftIndex++]);
            }else{
                val += Math.max(0,rightMax - height[rightIndex]);
                rightMax = Math.max(rightMax,height[rightIndex--]);
            }
        }
        return val;
    }
}