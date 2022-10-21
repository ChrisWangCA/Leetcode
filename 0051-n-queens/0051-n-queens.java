class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queen = new int[n];
        Arrays.fill(queen,0);
        List<List<String>> res = new ArrayList<>();
        process(res,queen,0,n);
        return res;
    }
    
    public void process(List<List<String>> res,int[] queen,int cur,int N){
        if(cur >= N){
            List<String> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                char[] chs = new char[N];
                Arrays.fill(chs,'.');
                chs[queen[i]] = 'Q';
                list.add(new String(chs));
            }
            res.add(list);
        }
        for(int j=0;j<N;j++){
            if(isValid(queen,cur,j)){
                queen[cur] = j;
                process(res,queen,cur+1,N);
            }
        }
    }
    
    public boolean isValid(int[] queen,int cur,int j){
        for(int k=0;k<cur;k++){
            if(queen[k] == j || Math.abs(queen[k] - j) == Math.abs(cur - k)){
                return false;
            }
        }
        return true;
    }
}