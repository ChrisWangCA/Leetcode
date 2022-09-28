class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null) {
			return 0;
		}
		int count = 0;
		int N = grid.length; //行
		int M = grid[0].length; //列
		for (int i = 0; i < N; i++) { //循环行
			for (int j = 0; j < M; j++) { //循环列
				if (grid[i][j] == 1) { //等于1说明有岛了，然后开始感染旁边的1
					count = Math.max(count,infect2(grid, i, j, N, M,count));
				}
			}
		}
		return count;
	}

	//i当前行，j当前列，N总行，M总列
	public static int infect2(int[][] m, int i, int j, int N, int M,int count) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) { //大过滤器
			return 0;
		}
		//i,i没越界并且当前位置值是1
		m[i][j] = 2;
        int num = 1;
		//尝试上下左右有没有1，如果越界会被i<0||j<0直接返回
		num += infect2(m, i + 1, j, N, M,count);//尝试它的下面有没有1
		num +=infect2(m, i - 1, j, N, M,count);//尝试它的上面有没有1
		num +=infect2(m, i, j + 1, N, M,count);//尝试右边还有没有1
		num +=infect2(m, i, j - 1, N, M,count);
        return num;//尝试左边还有没有1
		
	}
    
}