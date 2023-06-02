class Solution {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int val = 0;
        int leftMax = height[0];
        int left = 1;
        int rightMax = height[height.length-1];
        int right = height.length-2;
        while(left <= right){
            if(leftMax <= rightMax){
                val += Math.max(0,leftMax - height[left]);
                leftMax = Math.max(leftMax,height[left++]);
            }else{
                val += Math.max(0,rightMax - height[right]);
                rightMax = Math.max(rightMax,height[right--]);
            }
        }
        return val;
    }
}