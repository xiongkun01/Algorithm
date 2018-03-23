/*
给定一个数组长度为N(N>1)的整型数组arr。
可以划分成左右两个部分，左部分为arr[0...k].
右部分为arr[k+1,...,N-1]，k可以取值的范围是[0,N-2]。
求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值中，最大是多少？
例如：[2,7,3,1,1]
当左部分为[2,7]，右部分为[3,1,1]时，左部分中的最大值减去右部分最大值的绝对值为4.
当左部分为[2,7,3]，右部分为[1,1]时，左部分中的最大值减去右部分最大值的绝对值为6.
还有很多划分方案，单最终返回6

最终的结果为:max - min{arr[0], arr[n - 1]}
*/
public class Problem04 {

	public static int maxABC(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("the length of arr is zero");
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i ++) {
			max = Math.max(max, arr[i]);
		}
		return max - Math.min(arr[0], arr[arr.length - 1]);
	}

	public static int[] generateRandomArray(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i ++) {
			arr[i] = (int) (Math.random() * 1000) - 499;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = generateRandomArray(200);
		System.out.println(maxABC(null));
	}

}