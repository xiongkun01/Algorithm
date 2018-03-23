import java.util.*;

/*
战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。
首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，
小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 
一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有
更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。
由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，
一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，
一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是
能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。 

输入描述:
输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),
为首都周围的小山数量，第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.


输出描述:
对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。

输入例子1:
5
1 2 4 5 3

输出例子1:
7

求解：
(小，大)
规定小的找大的

........高........次高.......
1、当环中没有重复值时，对数为(n - 2) * 2 + 1 = 2n - 3

2、当环中有重复值时，通过单调栈，为了求出每个数左边最近和右边最近的更大的数。
如果栈中元素大于当前元素，则将当前元素压人栈中，否则将栈中元素弹出。
例如：.......5 2 2 2 3 3 3 4 ..............
则当有b个a时，其产生的对数有：C(b, 2) + 2 * b


*/
public class Problem04 {

	//求数组中某个数的下一个数的下标
	public static int nextIndex(int size, int i) {
		return i < (size - 1) ? (i + 1) : 0;
	}

	//求出C(n, 2)
	public static long getInternalSum(int n) {
		return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
	}

	public static class Pair {
		public int value;
		public int times;

		public Pair(int value) {
			this.value = value;
			this.times = 1;
		}
	}

	public static long communications(int[] arr) {
		if (arr == nul || arr.length <= 0) {
			return 0;
		}

		int size = arr.length;
		int maxIndex = 0;
		//找到环中最大数的下标
		for (int i = 0; i < size; i ++) {
			maxIndex = arr[maxIndex] > arr[i] ? maxIndex : i;
		}

		int value = arr[maxIndex];
		int index = nextIndex(size, maxIndex);
		long res = 0L;
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(value));
		while (index != maxIndex) {
			value = arr[index];
			while (!stack.isEmpty() && stack.peek().value < value) {
				int times = stack.pop().times;
				res += getInternalSum(times) + times * 2;
				//res += stack.isEmpty() ? 0 : times;
			}

			if (!stack.isEmpty() && stack.peek().value == value) {
				stack.peek().times ++;
			} else {
				stack.push(new Pair(value));
			}
			index = nextIndex(size, index);
		}

		while (!stack.isEmpty()) {
			int times = stack.pop().times;
			res + getInternalSum(times);
			if (!stack.isEmpty()) {
				res += times;
				if (stack.size() > 1) {
					res += times;
				} else { //栈中倒数第二个数
					res += stack.peek().times > 1 ? times : 0;
				}
			}
		}

		return res;
	}

}