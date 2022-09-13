class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        if(nums == null || nums.length < 2) return res;
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<res.length;i++){
            res[i] = nums[i];
        }
        return res;
    };
    public void quickSort(int[] nums,int l,int r){
        if(l<r){
            swap(nums,l+(int)(Math.random()*(r-l+1)),r);
            int[] p = partition(nums,l,r);
            quickSort(nums,l,p[0]-1);
            quickSort(nums,p[1]+1,r);
        }
    }
    public int[] partition(int[] arr,int l,int r){
        int less = l-1;
        int more = r;
        while(l<more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}