class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        Arrays.fill(record,0);
        List<List<String>> res = new ArrayList<>();
        process(res,record,0,n);
        return res;
    }
    
    public void process(List<List<String>> res,int[] record,int cur,int n){
        if(cur >= n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] chs = new char[n];
                Arrays.fill(chs,'.');
                chs[record[i]] = 'Q';
                list.add(new String(chs));
            }
            res.add(list);
        }
        for(int j=0;j<n;j++){
            if(isValid(record,cur,j)){
                record[cur] = j;
                process(res,record,cur+1,n);
            }
        }
    }
    
    public boolean isValid(int[] record,int cur,int j){
        for(int k=0;k<cur;k++){
            if(record[k] == j || Math.abs(record[k] - j) == Math.abs(cur - k)){
                return false;
            }
        }
        return true;
    }
}