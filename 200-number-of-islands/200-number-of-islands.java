class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int row = grid.length;
        int column = grid[0].length;
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == '1'){
                    res++;
                    infect(grid,i,j,row,column);
                }
            }
        }
        return res;
    }
    public void infect(char[][] grid,int i,int j,int row,int column){
        if(i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid,i+1,j,row,column);
        infect(grid,i-1,j,row,column);
        infect(grid,i,j+1,row,column);
        infect(grid,i,j-1,row,column);
    }
}