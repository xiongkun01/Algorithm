/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
路径不能再次进入该格子。
*/
public class Problem02 {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || matrix.length <= 0 || rows <= 0 || cols <= 0 
			|| str == null || str.length <= 0) {
			return false;
		}
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, str, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
				int row, int col, int[] pathLength) {
		if (pathLength[0] == str.length) {
			return true;
		}
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols
			&& matrix[row * cols + col] == str[pathLength[0]]
			&& !visited[row * cols + col]) {
			visited[row * cols + col] = true;
			pathLength[0]++;
			//从四个位置进行回溯
			hashPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
					&& hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
					&& hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
					&& hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength);
			//若四周没有找到合适的点，则回到上一个位置
			if (!hashPath) {
				pathLength[0]--;
				visited[row * cols + col] = false;
			}
		}
		return hashPath;
	}
}