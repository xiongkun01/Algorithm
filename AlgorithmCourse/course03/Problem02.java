import java.util.*;

/*
给定一个二维数组，所有位置的值不是0就是1。规定每个位置可以和它上
下左右位置上的值相连。有一个叫做岛的概念，定义如下：
连成一片的1，如果周围都是0，那么这一片1，构成一个岛。
求整张图上有多少个岛。

进阶：
如果可以使用并行计算，如何来设计你的算法？

并查集
求解：通过CPU多核同时计算，但是需要记录每个区域的岛中心（触发infect函数的位置）和边界信息。
如果两个CPU核处理的区域边界有相邻的位置，则两个岛中心应该合并。
*/
public class Problem02 {


	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}

		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j ++) {
				if (m[i][j] == 1) {
					res ++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}
	
	//将一大片1改成一大片2
	public static void infect(int[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}

		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	//代表节点
	public Node findFather(Node n) {
		Node father = fatherMap.get(n);
		if (father != n) {
			father = findFather(father);
		}

		fatherMap.put(n, father);
		return father;
	}
	
	public void union(Node a, Node b) {
		Node aFather = findFather(a);
		Node bFather = findFather(b);
		if (aFather != bFather) {
			int aFrank = rankMap.get(aFather);
			int bFrank = rankMap.get(bFather);
			if (aFrank < bFrank) {
				fatherMap.put(aFrank, bFather);
			} else if (bFrank < aFrank) {
				fatherMap.put(bFrank, aFather);
			} else {
				fatherMap.put(bFrank, aFather);
				rankMap.put(aFather, aFrank + bFrank);
			}
		}
	}

	public static void main(String[] args) {

	}
}

