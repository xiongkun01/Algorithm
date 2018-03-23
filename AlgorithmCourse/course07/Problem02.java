/*
小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许
放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的
任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 <= i <= n)个棋子所需
要的最少操作数。

输入描述：
输入包括三行，第一行一个整数n(1 <= n <= 50)，表示棋子的个数，
第二行为n个棋子的横坐标x[i](1 <= x[i] <= 10^9)
第三行为n个棋子的纵坐标y[i](1 <= y[i] <= 10^9)

输出描述：
输出n个整数，第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数，以空格分割。
行末无空格

如样例所示：
对于1个棋子：不需要操作
对于2个棋子：将前两个棋子放在(1, 1)中
对于3个棋子：将前三个棋子放在(2, 1)中
对于4个棋子：将所有棋子放在(3, 1)中

输入例子1：
4
1 2 4 9
1 1 1 1

输出例子1：

求解：
曼哈顿距离：|X| + |Y|
只用试所有x与所有y的组合点就行。

使用优先级队列PriorityQueue

*/
public class Problem02 {

	public static void main(String[] args) {

	}

	public static int[] minPos(int size, int[] x, int[] y) {
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					pq.add(Math.abs(x[k] - x[i]), Math.abs(y[k] - y[j]));
				}
				int resI = 0;
				int sum = 0;
				while (!pq.isEmpty()) {
					sum += pq.poll();
					res[resI] = Math.min(res[resI], sum);
					resI++;
				}
			}
		}
		return res;
	}

}