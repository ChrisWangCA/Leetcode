class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid[0]==null) return 0;
        int res=0;
        int N=grid.length;
        int M=grid[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,infect(grid,i,j,N,M));
                }
            }
        }
        return res;
    }
    public int infect(int[][] chs,int i,int j,int N,int M){
        if(i<0 || i>=N || j<0 || j>=M || chs[i][j]!=1) return 0;
        chs[i][j]=2;
        int num=1;
        num+=infect(chs,i+1,j,N,M);
        num+=infect(chs,i-1,j,N,M);
        num+=infect(chs,i,j+1,N,M);
        num+=infect(chs,i,j-1,N,M);
        return num;
    }
}