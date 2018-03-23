public class CountSort {
	
	//计数排序，稳定的
	public static int[] countSort(int[] A, int n) {
		if (A == null || n == 0) {
			return null;
		}

		int max = A[0];
		for (int i = 1; i < n; i ++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		int[] result = new int[n];
		int[] temp = new int[max + 1];
		

		for (int i = 0; i < n; i ++) {
			temp[A[i]] ++;
		}
	
		int sum = 0;
		for (int i = 0; i < temp.length; i ++) {
			sum += temp[i];
			temp[i] = sum;
		}

		for (int j = n - 1; j >= 0; j --) {
			result[temp[A[j]] - 1] = A[j];
			temp[A[j]] --;
		}

		System.out.println("max:" + max);
		
		return result;
	}

	
	
	public static void main(String[] args) {
		int[] A = new int[] {2, 5, 3, 0, 2, 3, 0, 3};
		int[] result = countSort(A, A.length);

		for (int i = 0; i < result.length; i ++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}


}



