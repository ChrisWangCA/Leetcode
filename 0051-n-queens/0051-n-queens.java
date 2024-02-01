class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        Arrays.fill(record,0);
        List<List<String>> res = new ArrayList<>();
        backtracing(res,record,0,n);
        return res;
    }
    
    public void backtracing(List<List<String>> res,int[] record,int row,int n){
        if(row == n){
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
            if(isValid(record,row,i)){
                record[row] = i;
                backtracing(res,record,row+1,n);
            }
        }
    }
    
    public boolean isValid(int[] record, int row, int col){
        for(int i=0;i<row;i++){
            if(record[i] == col || Math.abs(record[i]-col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }
}