class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int N = grid.length;
        int M = grid[0].length;
        int res = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,infect(grid,i,j,N,M));
                }
            }
        }
        return res;
    }
    
    public int infect(int[][] grid,int i,int j,int N,int M){
        if(i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        int num = 1;
        num += infect(grid,i+1,j,N,M);
        num += infect(grid,i-1,j,N,M);
        num += infect(grid,i,j+1,N,M);
        num += infect(grid,i,j-1,N,M);
        return num;
    }
}