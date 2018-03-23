/*
有一排正数，玩家A和玩家B都可以看到。
每位玩家在拿走数字的时候，都只能从最左和最右的数中选择一个。
玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
两人都力争自己拿到的数的总和比对方多。请返回最后获胜者的分数。

例如：
5,2,3,4
玩家A先拿，当前他只能拿走5或者4。
如果玩家A拿走5，那么剩下2，3，4。轮到玩家B，此时玩家B可以选择2或4中的一个，…
如果玩家A拿走4，那么剩下5，2，3。轮到玩家B，此时玩家B可以选择5或3中的一个，…

*/
public class Problem03 {
	
	//先发者
	public static int f(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}
	
	//后发者
	public static int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}	
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	
	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i ++) {
			sum += arr[i];
		}
		
		int fValue = f(arr, 0, arr.length - 1);

		return Math.max(fValue, sum - fValue);
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = arr.length;
		int[][] f = new int[len][len];
		int[][] s = new int[len][len];
		for (int j = 0; j < len; j ++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i --) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}

		return Math.max(f[0][len - 1], s[0][len - 1]);
	}


	//先发者
	public static int p(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		if (i + 1 == j) {
			return Math.max(arr[i], arr[j]);
		}

		return Math.max(arr[i] + Math.min(p(arr, i + 1, j - 1), p(i + 2, j)),
						arr[j] + Math.min(p(arr, i + 1, j - 1), p(i, j - 2)));
	}

	public static int win3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i ++) {
			sum += arr[i];
		}
		
		int pValue = p(arr, 0, arr.length - 1);

		return Math.max(pValue, sum - pValue);
	}

	public static int win4(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		if (arr.length == 1) {
			return arr[0];
		}
		

	}


	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
