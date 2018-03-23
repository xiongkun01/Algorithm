public class DPProblem1 {

	
	public static void main(String[] args) {
		//硬币找零问题，状态转移方程为dp[i] = dp[i - a[j]] + 1
		int[] a = new int[] {1, 3, 5};
		int sum = 11;
		int[] dp = new int[sum + 1];
		
		dp[0] = 0;
		for(int i = 1; i <= sum; i ++) {
			dp[i] = i;
		}
		
		for(int i = 1; i <= sum; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(i >= a[j] && dp[i - a[j]] < dp[i]) {
					dp[i] = dp[i - a[j]] + 1;
				}
			}
		}

		System.out.println(dp[sum]);
	}
}
