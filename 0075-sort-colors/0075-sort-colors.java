class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length-1;
        for(int i=0;i<nums.length;i++){
            while(i < p2 && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
    }
}