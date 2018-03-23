/*
硬币找零问题
*/
public class ChargeDemo02 {

	public static void main(String[] args) {

	}

	//暴力搜索
	public int coins1(int[] arr, int aim) {
		if (arr == null || arr.length <= 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	public int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += process1(arr, index + 1, aim - arr[index] * i);
			}
		}
	}

	//记忆搜索，保存之前计算的值，避免重复计算，通过map来保存
	public int coins2(int[] arr, int aim) {
		if (arr == null || arr.length <= 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}

	public int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				if (mapValue != 0) {
					res += mapValue == -1 ? 0 : mapValue;
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}

	//动态规划过程，dp[i][j]表示只用arr[0 ---- i]的硬币表示j的数量，最终求dp[n - 1][aim]
	public int coins3(int[] arr, int aim) {
		if (arr == null || arr.length <= 0 || aim < 0) {
			return 0;
		}
		int row = arr.length;
		int col = aim + 1;
		int[][] dp = new int[row][col];
		for (int j = 0; j < col; j++) {
			dp[0][j] = j % arr[0] == 0 ? 1 : 0;
		}
		for (int i = 1; i < row; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < col; j++) {
				if (j < arr[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
				}
			}
		}
		return dp[row - 1][col - 1];
	}


}