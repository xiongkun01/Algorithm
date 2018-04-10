public class Problem_fac {

	//***********母牛生牛的问题：c(n) = c(n - 1) + c(n - 3)******************
	public int c1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return c1(n - 1) + c1(n - 3);
	}

	//时间复杂度为O(N)
	public int c2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res = 0;
		int first = 1, second = 2, third = 3;
		for (int i = 4; i <= n; i++) {
			res = first + third;
			first = second;
			second = third;
			third = res;
		}
		return res;
	}

	//时间复杂度为O(logN)
	public int c3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	//矩阵的N次方
	public int[][] matrixPower(int[][] m, int p) {
		in[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] temp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, temp);
			}
			temp = muliMatrix(temp, temp);
		}
	}

	//矩阵相乘
	public int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m1[0].length];
		for (int i = 0; i <= m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
	}

}