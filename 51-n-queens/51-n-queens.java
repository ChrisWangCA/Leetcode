class Solution {
   public List<List<String>> solveNQueens(int n) {
        int[] queen  = new int[n];
        Arrays.fill(queen,0);
        List<List<String>> res = new ArrayList<>();
        process(res,queen,0,n);
        return res;
    }

    public static void process(List<List<String>> res,int[] queen,int cur,int n){
        if (cur>=n){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chs = new char[n];
                Arrays.fill(chs,'.');
                chs[queen[i]] = 'Q';
                list.add(new String(chs));
            }
            res.add(list);
        }
        for (int j = 0; j < n; j++) {
            if (isValid(queen, cur, j)) {
                queen[cur] = j;
                process(res,queen,cur + 1, n);
            }
        }
    }

    public static boolean isValid(int[] queue, int cur, int j) {
        for (int k = 0; k < cur; k++) {
            if (j == queue[k] || Math.abs(queue[k] - j) == Math.abs(cur - k)) {
                return false;
            }
        }
        return true;
    }
}