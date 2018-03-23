/*
给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。

给定两个字符串A和B，同时给定两个串的长度n和m，
请返回最长公共子序列的长度。保证两串长度均小于等于300。

测试样例：
"1A2C3D4B56",10,"B1D23CA45B6A",12
返回：6
*/
public class LCSDemo02 {
	
	public static void main(String[] args) {

	}

	//dp[i][j]表示A[0....i]和B[0....j]的最长公共子序列的长度，最终求dp[n - 1][m - 1]
	public int findLCS(String A, int n, String B, int m) {
		if (A == null || n <= 0 || B == null || m <= 0) {
			return 0;
		}

		int[][] dp = new int[n][m];
		//第一行
		for (int j = 0; j < m; j++) {
			if (B.charAt(j) == A.charAt(0)) {
				int k = j;
				while (k < m) {
					dp[0][k++] = 1;
				}
				break;
			}
		}
		//第一列
		for (int i = 1; i < n; i++) {
			if (B.charAt(0) == A.charAt(i)) {
				int k = i;
				while (k < n) {
					dp[k++][0] = 1;
				}
				break;
			}
		}
		//其他位置
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n - 1][m - 1];
	}
}