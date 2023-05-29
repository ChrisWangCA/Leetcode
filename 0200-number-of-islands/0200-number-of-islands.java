class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    res++;
                    infect(grid,row,col,i,j);
                }
            }
        }
        return res;
    }
    
    public void infect(char[][] grid,int row,int col,int i,int j){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid,row,col,i+1,j);
        infect(grid,row,col,i-1,j);
        infect(grid,row,col,i,j+1);
        infect(grid,row,col,i,j-1);
    }
}