/*
求数组的最长递增子序列（不连续），子数组是连续的。
使用dp[i]表示必须以arr[i]结尾的情况下，arr[0......i]中的最大递增子序列的长度
*/
public class LISDemo02 {

	public static void main(String[] args) {

	}

	public int getLIS(int[] arr, int n) {
		if (arr == null || n <= 0) {
			return 0;
		}
		int result = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}