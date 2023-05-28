class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(res,list,nums);
        return res;
    }

    public void process(List<List<Integer>> res,List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            process(res,list,nums);
            list.remove(list.size()-1);
        }
    }
}