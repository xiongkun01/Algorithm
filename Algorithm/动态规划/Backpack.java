import java.util.*;

/**
一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，
记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，
选出物品的总价值最大。

给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。

测试样例：
[1,2,3],[1,2,3],3,6
返回：6

求解：
//dp[i][j]表示选用前i个物品的重量不超过j的最大价值
dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);

*/
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        if (w == null || v == null || n <= 0 || cap <= 0) {
			return 0;
		}
		
		int[][] dp = new int[n][cap + 1];
		for (int i = 0; i < cap + 1; i ++) {
			if (i > w[0]) {
				dp[0][i] = v[0];
			}
		}
		

		for (int x = 1; x < n; x ++) {
			for (int y = 1; y < cap + 1; y ++) {
				if (y - w[x] > 0) {
					dp[x][y] = Math.max(dp[x - 1][y], dp[x - 1][y - w[x]] + v[x]); 
				} else {
					dp[x][y] = dp[x - 1][y];
				}
			}
		}
		return dp[n - 1][cap];
    }
}