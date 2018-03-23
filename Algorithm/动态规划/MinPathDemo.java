import java.util.*;

public class MinPathDemo {
	
	
	public static int minPath(int[][] chess) {
		if (chess == null || chess.length == 0) {
			return 0;
		}

		int row = chess.length;
		int col = chess[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = chess[0][0];
		for (int i = 1; i < row; i ++) {
			dp[i][0] = dp[i - 1][0] + chess[i][0];
 		}
		for (int j = 1; j < col; j ++) {
			dp[0][j] = dp[0][j - 1] + chess[0][j];
		}

		for (int i = 1; i < row; i ++) {
			for (int j = 1; j < col; j ++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + chess[i][j];
			}
		}

		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		Random ran = new Random();

		int[][] chess = new int[5][6];
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j ++) {
				chess[i][j] = ran.nextInt(1000);
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}

		int min = minPath(chess);
		System.out.println("The minimum path is : " + min);
	}
}
