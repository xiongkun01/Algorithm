public class Problem_getMaxLength {
	
	//求未排序正数数组中累加和为给定值的最长子数组长度
	public static int getMaxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int left = 0, right = 0;
		int sum = arr[0];
		int len = 0;
		while (right < arr.length) {
			if (sum == k) {
				len = Math.max(len, right - left + 1);
				sum -= arr[left++];
			} else if (sum > k) {
				sum -= arr[left++];
			} else {
				right++;
				if (right < arr.length) {
					break;
				}
				sum += arr[right];
			}
		}
		return len;
	}
	
}