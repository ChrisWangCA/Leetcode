class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			process(matrix, tR++, tC++, dR--, dC--,res);
		}
        return res;
    }
    public void process(int[][] m, int tR, int tC, int dR, int dC,List<Integer> res){
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				res.add(m[tR][i]);
			}
		} else if (tC == dC) {
			for (int i = tR; i <= dR; i++) {
				res.add(m[i][tC]);
			}
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				res.add(m[tR][curC]);
				curC++;
			}
			while (curR != dR) {
				res.add(m[curR][dC]);
				curR++;
			}
			while (curC != tC) {
				res.add(m[dR][curC]);
				curC--;
			}
			while (curR != tR) {
				res.add(m[curR][tC]);
				curR--;
			}
		}
    }
}