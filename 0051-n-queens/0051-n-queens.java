class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        Arrays.fill(record,0);
        backtracing(record,0,n);
        return res;
    }
    public void backtracing(int[] record,int cur,int n){
        if(cur == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] chs = new char[n];
                Arrays.fill(chs,'.');
                chs[record[i]] = 'Q';
                list.add(new String(chs));
            }
            res.add(list);
        }
        for(int i=0;i<n;i++){
            if(isValid(record,cur,i)){
                record[cur] = i;
                backtracing(record,cur+1,n);
            }
        }
    }
    public boolean isValid(int[] record,int cur, int j){
        for(int i=0;i<cur;i++){
            if(record[i] == j || Math.abs(record[i]-j) == Math.abs(cur-i)){
                return false;
            }
        }
        return true;
    }
}