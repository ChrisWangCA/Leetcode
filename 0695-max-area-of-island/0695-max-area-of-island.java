class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,infect(grid,i,j,row,col));
                }
            }
        }
        return res;
    }
    
    public int infect(int[][] grid,int i,int j,int row,int col){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        int num = 1;
        num += infect(grid,i+1,j,row,col);
        num += infect(grid,i-1,j,row,col);
        num += infect(grid,i,j+1,row,col);
        num += infect(grid,i,j-1,row,col);
        return num;
    }
}