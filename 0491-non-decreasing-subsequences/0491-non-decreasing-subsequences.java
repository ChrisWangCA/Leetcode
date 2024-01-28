class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracing(nums,0);
        return res;
    }
    
    public void backtracing(int[] nums,int startIndex){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=startIndex;i<nums.length;i++){
            if(!path.isEmpty() && nums[i] < path.get(path.size()-1) || set.contains(nums[i])) continue;
            path.add(nums[i]);
            set.add(nums[i]);
            backtracing(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}