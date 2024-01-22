class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(k,n,0,1);
        return res;
    }
    
    public void backtracing(int k,int target,int sum, int startIndex){
        if(sum > target) return;
        if(path.size() == k){
            if(target == sum){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=startIndex;i<=9;i++){
            path.add(i);
            sum += i;
            backtracing(k,target,sum,i+1);
            sum -= i;
            path.remove(path.size()-1);
        }
    }
}