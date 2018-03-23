public class MergeSort {

	//归并排序是稳定的排序方法。归并排序的时间复杂度为O(nlogn)。速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
	public static void mergeSort(int[] A, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			//对左边归并排序
			mergeSort(A, left, middle);
			//对右边归并排序
			mergeSort(A, middle + 1, right);
			//将两个有序子数组合并
			merge(A, left, middle, right);
		}
	}

	public void mergeSort2(int[] arr) {
		int n = arr.length;
		if (arr == null || n <= 0) {
			return;
		}

		int groupSize = 2;
		while (groupSize < n) {
			for (int i = 0; i < n; i += groupSize) {
				int low = i;
				int high = Math.min(i + groupSize - 1, n - 1);
				int mid = low + groupSize - 1;

				merge(arr, low, mid >= high ? (low + high) / 2 : mid; high);
			}

			groupSize *= 2;
		}

		//对奇数组进行处理
		if (groupSize / 2 < n) {
			int low = 0;
			int high = n - 1;
			merge(arr, low, groupSize / 2 - 1, high);
		}
	}

	public static void merge(int[] A, int left, int middle, int right) {
		int[] temp = new int[right - left + 1]; //临时数组
        int i = left;
        int j = middle + 1;
        int t = 0;
        while (i <= middle && j <= right) {
            if (A[i] < A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }
        
        while (i <= middle) {
            temp[t++] = A[i++];
        }
        
        while (j <= right) {
            temp[t++] = A[j++];
        }
        
        //将临时数组中的数据拷贝到原数组
        t = 0;
        while (left <= right){
            A[left++] = temp[t++];
        }
	}

	public static void main(String[] args) {
		int[] A = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
		int[] temp = new int[A.length];
		mergeSort(A, 0, A.length - 1);

		for (int i = 0; i < A.length; i ++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
