class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracing(n,k,1);
        return res;
    }
    
    public void backtracing(int n,int k,int startIndex){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=startIndex;i<=n;i++){
            list.add(i);
            backtracing(n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}