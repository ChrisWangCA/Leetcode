class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int val = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int l = 1;
        int r = height.length-2;
        while(l <= r){
            if(leftMax <= rightMax){
                val += Math.max(0,leftMax - height[l]);
                leftMax = Math.max(leftMax,height[l++]);
            }else{
                val += Math.max(0,rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r--]);
            }
        }
        return val;
    }
}