public class MinPath {

	//矩阵的最小路径和
	public int minPath(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int rows = m.length, cols = m[0].length;
		int[][] dp = new int[rows][cols];
		dp[0][0] = m[0][0];
		//第一行dp[0][j]
		for (int j = 1; j < cols; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		//第一列dp[i][0]
		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + m[i][j];
			}
		}
		return dp[rows - 1][cols - 1];
	}

	//压缩空间的方法
	public int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int rows = m.length, cols = m[0].length;
		int more = Math.max(rows, cols);
		int less = Math.min(rows, cols);
		boolean rowMore = more == rows;
		int[] dp = new int[less];
		dp[0] = m[0][0];
		for (int i = 1; i < less; i++) {
			dp[i] = dp[i - 1] + (rowMore ? m[0][i] : m[i][0]);
		}
		for (int i = 1; i < more; i++) {
			dp[0] = dp[0] + (rowMore ? m[i][0] : m[0][i]);
			for (int j = 1; j < less; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? m[i][j] : m[j][i]);
			}
		}
		return dp[less - 1];
	}

}