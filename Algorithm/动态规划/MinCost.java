import java.util.*;

/**
对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，
请设计一个高效算法，求出将A串变为B串所需要的最少代价。

给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
保证两串长度均小于等于300，且三种代价值均小于等于100。

测试样例：
"abc",3,"adc",3,5,3,100
返回：8

*/
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		// write code here
        //dp[i][j] 表示在字符串A(0到i位置)变换到字符串B(0到j号位置)所需的最小代价。
        //设置n+1和m+1的原因是：0号位置用来代表""空字符串，即什么都没有的情况
		int[][] dp = new int[n + 1][m + 1];
		
		//从A(0...i)变换到空字符串"",需要将A中字符全删除，即代价为：c1 * i
		for (int i = 0; i < n + 1; i ++) {
			dp[i][0] =  c1 * i;
		}
		
		//从空字符串""变换到B(0...j),x需要添加B字符串中的所有字符，所以代价为：c0 * j
		for (int j = 0; j <= m; j ++) {
			dp[0][j] = c0 * j;
		}
		
		//如果修改操作大于增加和删除操作的和，即替换。因为添加和删除操作可以组成替换操作
		if (c2 > c0 + c1) {
			c2 = c0 + c1;
		}

		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					

					dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i][j - 1] + c0, dp[i - 1][j] + c1));
				} else {
					
					dp[i][j] = Math.min(dp[i - 1][j - 1] + c2,
                            Math.min(dp[i][j - 1] + c0, dp[i - 1][j] + c1));
				}
			}
		}
		return dp[n][m];
	   
    }
}