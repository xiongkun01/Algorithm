public class Problem_findSumIsN {

	public static void main(String[] args) {

	}

	public static void findSumIsN(int n) {
		if (n <= 0) {
			return;
		}
		int start = 1, end = 2;
		int sum = start + end;
		while (start < (n + 1) / 2) {
			if (sum == n) {
				printArr(start, end);
			}
			while (sum < n) {
				end++;
				sum += end;
				if (sum == n) {
					printArr(start, end);
				}
			}
			sum -= start;
			start++;
		}
	}

	public static int sum(int start, int end) {
		int res = 0;
		for (int i = start; i <= end; i++) {
			res += i;
		}
		return res;
	}

	public static void printArr(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(start + " ");
		}
		System.out.println();
	}

}