public class Problem_fillColor {

	//****************递归分为过程递归和结构递归两种*******************

	//矩阵染色，注意：对角元素不算临近
	public void fillWithColor(int[][] map, int i, int j, int c) {
		if (i > map.length - 1 || j > map[0].length - 1) {
			return;
		}
		int temp = map[i][j];
		map[i][j] = c;
		if (i - 1 >= 0 && map[i - 1][j] == temp) {
			fillWithColor(map, i - 1, j, c);
		}
		if (i + 1 < map.length && map[i + 1][j] == temp) {
			fillWithColor(map, i + 1, j, c);
		}
		if (j - 1 >= 0 && map[i][j - 1] == temp) {
			fillWithColor(map, i, j - 1, c);
		}
		if (j + 1 < map[0].length && map[i][j + 1] == temp) {
			fillWithColor(map, i, j + 1, c);
		}
	}

	//n!
	public int f(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * f(n - 1);
	}

	//斐波拉契数列
	public int fac(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		reurn fac(n - 1) * fac(n - 2);
	}

	//全排列
	public void permutation(int[] arr, int m, int n) {
		if (m > n - 1) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		} else {
			for (int i = m; i < n; i++) {
				swap(arr, i, m);
				permutation(arr, m + 1, n);
				swap(arr, i, m);
			}
		}
	}

	//*********************结构递归************************
	public void reprint(int[] arr, int i, int n) {
		if (i > n - 1) {
			return;
		}
		/*这里在不停的递归，知道当i == n的时候就开始弹他会弹到上一层调用的地方，
		并且开始执行调用函数下面的语句*/ 
		reprint(i + 1);
		/*弹出后就会到这个位置来开始执行下面的语句，所以我们只需要在这里打印即可*/ 
		System.out.print(arr[i] + " ");
	}
}