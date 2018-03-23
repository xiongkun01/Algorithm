import java.util.*;

public class ChargeDemo {
	
	public static int charge(int[] money, int total) {
		int row = money.length;
		int col = total + 1;
		int[][] dp = new int[row][col];
		for (int j = 0; j < col; j ++) {
			if (j % money[0] == 0) {
				dp[0][j] = 1;
			}
		}

		for (int i = 1; i < row; i ++) {
			dp[i][0] = 1;
			for (int j = 1; j < col; j ++) {
				if (j >= money[i]) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - money[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int[] money = new int[] {1, 2, 5, 10, 20, 50, 100};
		int total = 100;

		int result = charge(money, total);
		System.out.println(result);
	}
}
