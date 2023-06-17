class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        if(nums == null || nums.length < 2) return res;
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] nums,int left,int right){
        if(left < right){
            swap(nums,left + (int)(Math.random() * (right-left+1)),right);
            int[] p = partition(nums,left,right);
            quickSort(nums,left,p[0]-1);
            quickSort(nums,p[1]+1,right);
        }
    }
    
    public int[] partition(int[] nums,int left,int right){
        int less = left-1;
        int more = right;
        while(left<more){
            if(nums[left] < nums[right]){
                swap(nums,++less,left++);
            }else if(nums[left] > nums[right]){
                swap(nums,--more,left);
            }else{
                left++;
            }
        }
        swap(nums,more,right);
        return new int[]{less+1,more};
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}