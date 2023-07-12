class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void mergeSort(int[] arr,int left,int right){
        if(left == right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }
    
    public void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int mid = rightPtr-1;
        int[] temp = new int[rightBound-leftPtr+1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while(i<=mid && j<=rightBound){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= rightBound){
            temp[k++] = arr[j++];
        }
        for(int l=0;l<temp.length;l++){
            arr[leftPtr+l] = temp[l];
        }
    }
}