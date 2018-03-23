/*
一排有N个位置，一个机器人在最开始停留在P位置上，如果p==0位置，下一分钟机器人一定向右
移动到1位置；如果p==N-1，下一分钟机器人一定向左移动到N-2位置。如果P在0和N-1之间，
下一分钟机器人一定会向左或者向右移动。求K分钟的时候，机器人到达T位置有多少种走法。

函数：int f(int N, int P, int K, int T),返回值为走法的数量。
*/

public class Problem05 {

	public static void main(String[] args) {

	}

	//K从1开始的，不是从0开始的
	public static int f1(int N, int P, int K, int T) {
		if (N < 2 || P < 0 || K < 1 || T < 0 || P >= N || T >= N) {
			return 0;
		}
		if (K == 1) {
			return T == P ? 1 : 0;
		}
		if (T == 0) {
			return f1(N, P, K - 1, T + 1);
		}
		if (T == N - 1) {
			return f1(N, P, K - 1, T - 1);
		}
		return f1(N, P, K - 1, T - 1) + f1(N, P, K - 1, T + 1);
	}
	

}