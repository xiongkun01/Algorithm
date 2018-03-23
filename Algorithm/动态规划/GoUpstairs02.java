/*
有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
为了防止溢出，请将结果Mod 1000000007

给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

测试样例：
1
返回：1
*/
public class GoUpstairs02 {

	public static void main(String[] args) {

	}

	public static int countWays(int n) {
		if (n < 1) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n];
	}

}