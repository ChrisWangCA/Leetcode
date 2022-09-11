class Solution {
    public int[] sortArray(int[] nums) {
        int[] arr = new int[nums.length];
        if(nums == null || nums.length < 2) return arr;
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<arr.length;i++){
            arr[i] = nums[i];
        }
        return arr;
    }
    public static void quickSort(int[] nums,int L,int R){
        if(L<R){
            swap(nums,L+(int)(Math.random()*(R-L+1)),R);
            int[] p = partition(nums,L,R);
            quickSort(nums,L,p[0]-1);
            quickSort(nums,p[1]+1,R);
        }
    }
    public static int[] partition(int[] nums,int L,int R){
        int less = L - 1;
        int more = R;
        while(L<more){
            if(nums[L] < nums[R]){
                swap(nums,++less,L++);
            }else if(nums[L] > nums[R]){
                swap(nums,--more,L);
            }else{
                L++;
            }
        }
        swap(nums,more,R);
        return new int[]{less+1,more};
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}