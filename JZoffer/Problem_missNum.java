public class Problem_missNum {

	//数组中未出现的最小正整数，正整数从1开始
	public static int missNum(int[] arr) {
		int l = 0; //表示遍历到目前为止已经包含的正整数范围[1, l]
		int r = arr.length; //表示遍历到目前为止，在后序出现最优状况的情况下，arr可能包含的正整数范围是[1,r]
		while (l < r) {
			if (arr[l] == l + 1) {
				l++;
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
				arr[l] = arr[--r];
			} else {
				swap(arr, l, arr[l] - 1);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}