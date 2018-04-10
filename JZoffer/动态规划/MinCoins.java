public class MinCoins {

	//换钱的最少硬币数，每个硬币可以用多次
	public int minCoins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j - arr[i] > = 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(dp[i - 1][j], left);
			}  
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	//每种硬币最多只能用一张
	public int minCoins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[0][j] = max;
		}
		if (arr[0] <= aim) {
			dp[0][arr[0]] = 1;
		}
		int leftUp = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				leftUp = max;
				if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
					leftUp = dp[i - 1][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(dp[i - 1][j], leftUp);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	//空间压缩方法
	public int minCoins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[j] = max;
		}
		if (arr[0] <= aim) {
			dp[arr[0]] = 1;
		}
		int leftUp = 0;
		for (int i = 1; i < n; i++) {
			for (int j = aim; j > 0; j--) {
				leftUp = max;
				if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
					leftUp = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(dp[j], leftUp);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}
}