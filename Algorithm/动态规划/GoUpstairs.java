import java.util.*;

/*
有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007

给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

f(1) = 1;
f(2) = 2;
f(i) = f(i - 1) + f(i - 2); 当i>2时
*/
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
		if (n < 1) {
			return 0;
		}

		if (n == 1 || n == 2) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i ++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n];
    }
}