class Solution {
    public int numTrees(int n) {
        if (n < 2) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				num[i] += num[j - 1] * num[i - j];
			}
		}
		return num[n];
    }
}