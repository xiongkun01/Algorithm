/*
N皇后问题指在NxN的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，也
不在同一条斜线上。给定一个整数n，返回n皇后的摆法有多少种。
如果(a,b)满足|a-i|==|b-j|，则说明(a,b)和(i,j)在同一条斜线上
*/
public class NQueen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(num1(n));
	}

	public static int num1(int n) {
		if (n < 1) {
			return 0;
		}
		int[] record = new int[n];
		return process1(0, record, n);
	}

	public static int process1(int i, int[] record, int n) {
		if (i == n) {
			return 1;
		}
		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}

	public static boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}

}