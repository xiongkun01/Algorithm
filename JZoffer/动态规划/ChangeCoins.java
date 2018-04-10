public class ChangeCoins {

	public int coins(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		//表示组成钱数为0的方法数为1
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				num = 0;
				for (int k = 0; j - k * arr[i] >= 0; k++) {
					num += dp[i - 1][j - k * arr[i]];
				}
				dp[i][j] = num;
			}
		}
		return dp[n - 1][aim];
	}


	public int conis2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int n = arr.length;
		int[][] dp = new int[n][aim + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][j * arr[0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0; //此处表达式化简了枚举的过程
			}
		}
		return dp[n - 1][aim];
	}

	//空间压缩优化
	public int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int n = arr.length;
		int[] dp = new int[aim + 1];
		for (int j = 0; arr[0] * j <= aim; j++) {
			dp[arr[0] * j] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				//其中右边的dp[j]表示dp[i - 1][j]，dp[j - arr[i]]表示dp[i][j - arr[i]]
				dp[j] = dp[j] +  j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
			}
		}
		return dp[aim];
	}

	
}