class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracing(candidates,target,0,0);
        return res;
    }
    
    public void backtracing(int[] nums,int target,int sum, int startIndex){
        if(sum>target) return;
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            if(i > startIndex && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            sum += nums[i];
            backtracing(nums,target,sum,i+1);
            sum -= nums[i];
            path.remove(path.size()-1);
        }
    }
}