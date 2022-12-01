class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] records = new int[n];
        Arrays.fill(records,0);
        List<List<String>> res = new ArrayList<>();
        process(res,records,0,n);
        return res;
    }
    
    public void process(List<List<String>> res,int[] records,int cur,int n){
        if(cur >= n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] chs = new char[n];
                Arrays.fill(chs,'.');
                chs[records[i]] = 'Q';
                list.add(new String(chs));
            }
            res.add(list);
        }
        for(int j=0;j<n;j++){
            if(isValid(records,cur,j)){
                records[cur] = j;
                process(res,records,cur+1,n);
            }
        }
    }  
    public boolean isValid(int[] records,int cur,int j){
        for(int k=0;k<cur;k++){
            if(records[k] == j || Math.abs(records[k] - j) == Math.abs(cur - k)){
                return false;
            }
        }
        return true;
    }
}