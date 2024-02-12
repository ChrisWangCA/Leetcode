class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracing(candidates,target,0,0);
        return res;
    }
    
    public void backtracing(int[] arrs,int target,int sum,int startIndex){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum > target) return;
        for(int i=startIndex;i<arrs.length;i++){
            sum += arrs[i];
            path.add(arrs[i]);
            backtracing(arrs,target,sum,i);
            sum -= arrs[i];
            path.remove(path.size()-1);
        }
    }
}