import java.util.*;

/*
给定一个数组arr,返回子数组的最大累加和。
例如，arr=[1, -2, 3, 5, -2, 6, -1]，所有的子数组中，[3, 5, -2, 6]可以累加出最大的和12，
所以返回12
*/
public class Problem03 {

	public static int maxSubArrSum(int[] arr) {
		int n = arr.length;
		if (arr == null || n <= 0) {
			return 0;
		}

		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i ++) {
			cur += arr[i];
			max = Math.max(cur, max);
			//当cur小于0时，将其置零
			cur = cur < 0 ? 0 : cur;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, -2, 3, 5, -2, 6, -1};

		System.out.println(maxSubArrSum(arr));
	}

}