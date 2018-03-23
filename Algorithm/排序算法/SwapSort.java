public class SwapSort {

	//冒泡排序是一种稳定的排序方法，平均时间复杂度为O(n2)
	public static void bubbleSort(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}

		for (int i = 0; i < n - 1; i ++) {
			for (int j = 0; j < n - i - 1; j ++) {
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
	}
	
	//快速排序是不稳定的排序。快速排序的时间复杂度为O(nlogn)。当n较大时使用快排比较好，当序列基本有序时用快排反而不好。
	public static void quick(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}
		
		quickSort(A, 0, n - 1);
	}

	public static void quickSort(int[] A, int low, int high) {
		if (low < high) {
			int middle = getMiddle(A, low, high);
			quickSort(A, 0, middle - 1);
			quickSort(A, middle + 1, high);
		}
	}

	public static int getMiddle(int[] A, int low, int high) {
		//基准元素
		int temp = A[low];
		while (low < high) {
			//找到比基准元素小的元素位置
			while (low < high && A[high] >= temp) {
				high --;
			}
			A[low] = A[high];
			while (low < high && A[low] <= temp) {
				low ++;
			}

			A[high] = A[low];
		}

		A[low] = temp;
		return low;
	}

	public static void main(String[] args) {
		int[] A = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
		quick(A);

		for (int i = 0; i < A.length; i ++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
