public class InsertSort {
	
	//直接插入排序,稳定的，当初态为正序时，算法的时间复杂度为o(n)；若初态为反序时，算法的时间复杂度为o(n^2)
	public static void insertSort1(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}
		
		for (int i = 1; i < n; i ++) {
			int temp = A[i];
			int j = 0;
			for (j = i - 1; j >= 0; j --) {
				//将大于temp的往后移动一位
				if (A[j] > temp) {
					A[j + 1] = A[j];
				} else {
					break;
				}
			}

			A[j + 1] = temp; //插入合适的位置
		}
		
	}

	//二分法插入排序，稳定，二分插入排序的比较次数与待排序记录的初始状态无关，仅依赖于记录的个数
	public static void insertSort2(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}

		for (int i = 0; i < n; i ++) {
			int temp = A[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (temp > A[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
			//将大于temp的数向后移一位
			for (int j = i - 1; j >= left; j --) {
				A[j + 1] = A[j];
			}
			
			 //插入位置为left或者right + 1
			if (left != i) {
				A[left] = temp;
			}

		}

	}
	
	//希尔排序，不稳定的排序算法，其实是一种分组排序算法，组内进行直接插入排序，时间复杂度为o(nlogn)
	public static void insertSort3(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		
		int d = A.length;
		while (true) {
			d = d / 2;
			
			for (int x = 0; x < d; x ++) {
				//组内进行直接插入排序
				for (int i = x + d; i < A.length; i += d) {
					int temp = A[i];
					int j;
					for (j = i - d; j >= 0; j -= d) {
						if (A[j] > temp) {
							A[j + d] = A[j];
						} else {
							break;
						}
					}

					A[j + d] = temp;
				}
			}

			if (d == 1) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
		insertSort3(A);

		for (int i = 0; i < A.length; i ++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
