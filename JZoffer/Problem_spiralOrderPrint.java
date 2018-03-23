public class Problem_spiralOrderPrint {

	public static void main(String[] args) {
		
	}

	public static void spiralOrderPrint(int[][] matrix) {
		if (matrix == null || matrix[0] == null || matrix.length < 1 || matrix[0].length < 1) {
			return;
		}
		//一个子矩阵可以通过两个坐标来确定，一个是左上角，一个是右下角
		int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) { //子矩阵只有一行时
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) { //只有一列时
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			} 
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) { //第一行
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) { //第二列
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) { //第二行
				System.out.print(m[curR][curC]);
				curC--;
			}
			while (curR != tR) { //第一列
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}

}