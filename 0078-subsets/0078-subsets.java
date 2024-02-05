class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracing(nums,0);
        return res;
    }
    
    public void backtracing(int[] nums,int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex == nums.length){
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracing(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}