class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid[0] == null) return res;
        int N = grid.length;
        int M = grid[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j] == '1'){
                    res++;
                    infect(grid,i,j,N,M);
                }
            }
        }
        return res;
    }
    
    public void infect(char[][] grid,int i,int j,int N,int M){
        if(i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != '1') return;
        grid[i][j] = '2';
        infect(grid,i+1,j,N,M);
        infect(grid,i-1,j,N,M);
        infect(grid,i,j+1,N,M);
        infect(grid,i,j-1,N,M);
    }
}