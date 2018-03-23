/*
有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。

给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.

测试样例：
[[1,2,3],[1,1,1]],2,3
返回：4
*/
public class MinimumPath02 {

	public static void main(String[] args) {

	}

	//dp[i][j]表示从(0,0)位置到(i,j)位置的最小路径和，最终求dp[n - 1][m - 1];
	public int getMin(int[][] map, int n, int m) {
		if (map == null || n <= 0 || m <= 0) {
			return 0;
		}
		int[][] dp = new int[n][m];
		int sum = 0;
		for (int j = 0; j < m; j++) {
			sum += map[0][j];
			dp[0][j] = sum;
		}
		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += map[i][0];
			dp[i][0] = sum;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
			}
		}
		return dp[n - 1][m - 1];
	}

	public int getMin2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		boolean rowmore = more == m.length;
		int[] arr = new int[less];
		arr[0] = m[0][0];
		for (int i = 1; i < less; i++) {
			arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
		}
		for (int i = 1; i < more; i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
			for (int j = 1; j < less; j++) {
				arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
		return arr[less - 1];
	}

}