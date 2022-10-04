class Solution {
    public int[][] generateMatrix(int n) {
        int loop = 0;
        int[][] res = new int[n][n];
        int start = 0;
        int count = 1;
        int i,j;
        while(loop++ < n / 2){
            for(j = start;j < n - loop;j++){
                res[start][j] = count++;
            }
            for(i = start;i < n - loop;i++){
                res[i][j] = count++;
            }
            for(;j >= loop;j--){
                res[i][j] = count++;
            }
            for(;i >= loop;i--){
                res[i][j] = count++;
            }
            start ++;
        }
        if(n % 2 == 1){
            res[start][start] = count;
        }
        return res;
    }
}