/*
给定一个数组，长度大于2。找出不相交的两个子数组，情况是
很多的。请返回这么多情况中，两个不相交子数组最大的和。
例如：
1,3,4,-9,1,2
当两个不相交子数组为[3,4]和[1,2]时，可以得到最大的和为10.
*/
public class Problem03 {

	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The length of arr is 0");
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;

		for (int i = 0; i < arr.length; i ++) {
			cur += arr[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}

	

}