public class Subsequence {
	
	//给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
	//(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
	public static int shortestSubsequence(int[] A, int n) {
		if (A == null || n == 0) {
			return 0;
		}

		int min = A[n - 1];
		int noMinIndex = -1;
		//先从右向左遍历
		for (int i = n - 2; i >= 0; i --) {
			if (A[i] > min) {
				noMinIndex = i;
			} else {
				min = A[i];
			}
		}

		if (noMinIndex == -1) {
			return 0;
		}

		int max = A[0];
		int noMaxIndex = -1;
		//再从左向右遍历
		for (int i = 1; i < n; i ++) {
			if (A[i] < max) {
				noMaxIndex = i;
			} else {
				max = A[i];
			}
		}

		return noMaxIndex - noMinIndex + 1;
	}

	public static void main(String[] args) {
		int[] A = new int[] {1,2,6,5,8,9};
		int result = shortestSubsequence(A, A.length);

		System.out.println(result);
	}
}
