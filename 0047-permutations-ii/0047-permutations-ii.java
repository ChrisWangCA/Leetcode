class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracing(nums,used);
        return res;
    }
    public void backtracing(int[] nums,boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false) continue;
            if(used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracing(nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}