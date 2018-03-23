import java.util.Scanner;

public class DPProblem2 {

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int i, j, n;

		System.out.print("请输入行数：");
		n = scan.nextInt();

		int[][] a = new int[100][100];
		for (i = 0; i < n; i ++) {
			for (j = 0; j <= i; j ++) {
				a[i][j] = scan.nextInt();
			}
		}

		for (i = n - 1; i > 0; i --) {
			for (j = 0; j < i; j ++) {
				a[i - 1][j] += max(a[i][j], a[i][j + 1]);
			}
		}
		System.out.println(a[0][0]);
	}
}
