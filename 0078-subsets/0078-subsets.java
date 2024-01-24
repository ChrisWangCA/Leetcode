class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracing(nums,0);
        return res;
    }
    
    public void backtracing(int[] nums,int startIndex){
        if(startIndex == nums.length){
            // res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracing(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}