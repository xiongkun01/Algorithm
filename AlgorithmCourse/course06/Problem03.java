/*
如果一个01串任意两个相邻位置的字符都是不一样的，我们就叫这个01串为交错01串。例如：
“1”，“10101”，“0101010”都是交错01串。小易现在有一个01串s，小易想找出一个最长的连续
子串，并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。

输入描述：
输入包括字符串s，s的长度length(1 <= length <= 50)，字符串中只包含‘0’和‘1’。
题目三扩展：
小易想找出一个最长的连续子串，并且这个子串是0和1数量相等的。该怎么做？

*/

import java.util.Scanner;
import java.util.Random;

public class Problem03 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.replaceAll(" +", "");
		int len = 1;
		int max = 1;
		for (int i = 1; i < str.length; i++) {
			len = (arr[i] == arr[i - 1]) ? 1 : ++len;
			max = Math.max(len, max);
		}
		System.out.println(max);
	}

	public static int getMaxlength(int[] arr, int aim) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(i - map.get(sum - aim), len);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}

	public static void generateArray(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The size of array should be largger than zero");
		}
		int[] result = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			result[i] = random.nextInt(100) + 5;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}	


}