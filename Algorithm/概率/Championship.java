import java.util.*;

/**
有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？

给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数

测试样例：
4
返回：[3,7]
*/
public class Championship {
    public int[] calc(int k) {
        // write code here
		if (k <= 0) {
			return null;
		}

		int n = 1; //总的队数
		for (int i = 2 * k - 1; i >= 1; i -= 2) {
			n *= i;
		}
		
		//两强不相遇的数量
		int m = fac(k - 1) * (k + 1) * k / 2;
		//两强相遇的数量
		int u = n - m;

		//求两个数的公约数
		int d = gcd(u, n);
		return new int[] {u / d, n / d};
    }
	
	//求n!
	public int fac(int n) {
		int res = 1;
		for (int i = 1; i <= n; i ++) {
			res *= i;
		}
		return res;
	}
	
	//辗转相除法求两数的公约数
	public int gcd(int a, int b) {
		int temp = 0;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}

		while (a % b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}
}