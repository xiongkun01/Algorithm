import java.util.*;

/**
给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，
”123456"或者"12C4B6"都是最长公共子序列。

给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。
保证两串长度均小于等于300。

测试样例：
"1A2C3D4B56",10,"B1D23CA45B6A",12
返回：6

求解：

*/
public class LCS {
    public static int findLCS(String A, int n, String B, int m) {
        // write code here
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n; i ++) {
            dp[i][0] = 0;
		}

		for (int j = 0; j < m; j ++) {
            dp[0][j] = 0;
		}

		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
				
			}
		}

		return dp[n][m];
    }

	public static void main(String[] args) {
		String A = "zynnqufc";
		String B = "ddbauhkw";

		System.out.println(findLCS(A, A.length(), B, B.length()));
	}
}