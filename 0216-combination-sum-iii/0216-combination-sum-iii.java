class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(k,n,1,0);
        return res;
    }
    
    public void backtracing(int k,int n,int startIndex,int sum){
        if(path.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=startIndex;i<=9;i++){
            sum += i;
            path.add(i);
            backtracing(k,n,i+1,sum);
            sum -= i;
            path.remove(path.size()-1);
        }
    }
}