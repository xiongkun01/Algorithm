public class SearchDemo {

	public static void main(String[] args) {

	}

	//二分查找，针对有序的数组，时间复杂度为O(log2n)，空间复杂度为O(1)
	public static int halfSearch(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int halfSearchLast(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0, high = arr.length - 1, mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (arr[mid] > num) {
				high = mid - 1;
			} else if (arr[mid] == num) {
				if (low == mid) {
					if (arr[high] == num) {
						return high;
					} else {
						return low;
					}
				} else {
					low = mid;
				}
			} else {
				low = mid + 1;
			}
		}
		if (arr[high] == num) {
			return high;
		}
		return -1;
	}


	public static int[] genRandomArray(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("the length of array is illegal!");
		}
		int[] arr = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt(100) + 1;
		}
		return arr;
	}

	public static void printArr(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}