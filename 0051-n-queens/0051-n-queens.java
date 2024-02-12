class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] record = new int[n];
        Arrays.fill(record,0);
        backtracing(res,record,0,n);
        return res;
    }
    public void backtracing(List<List<String>> res,int[] record,int cur,int n){
        if(cur == n){
            List<String> path = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] chs = new char[n];
                Arrays.fill(chs,'.');
                chs[record[i]] = 'Q';
                path.add(new String(chs));
            }
            res.add(path);
        }
        for(int j=0;j<n;j++){
            if(isValid(record,cur,j)){
                record[cur] = j;
                backtracing(res,record,cur+1,n);
            }
        }
    }
    public boolean isValid(int[] record,int cur,int j){
        for(int i=0;i<cur;i++){
            if(record[i] == j || Math.abs(record[i]-j) == Math.abs(cur - i)){
                return false;
            }
        }
        return true;
    }
}