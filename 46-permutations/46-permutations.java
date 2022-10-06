class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(nums,list,res);
        return res;
    }
    
    public void process(int[] nums,List<Integer> list,List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            process(nums,list,res);
            list.remove(list.size()-1);
        }
    }
}