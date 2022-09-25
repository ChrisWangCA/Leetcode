class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1) return res;
        process(nums,0,res);
        return res;
    }

    public static void process(int[] nums,int i,List<List<Integer>> res){
        if(i == nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            process(nums,i+1,res);
            swap(nums,i,j);
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}