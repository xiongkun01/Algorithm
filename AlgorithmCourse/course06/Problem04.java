/*
小易有一个长度为n的整数序列，a_1,.....,a_n。然后考虑在一个空序列b进行n次以下操作：
1、将a_i放入b序列的末尾
2、逆置b序列
小易需要你计算输出操作n次之后的b序列
输入描述：
输入包括两行，第一行包括一个整数n(2 <= n <= 2*10^5)，即序列的长度。
第二行包括n个整数a_i(1 <= a_i <= 10^9)，即序列a中的每个整数，以空格分割。

输出描述：
在一行中输出操作n次之后的b序列，以空格分割，行末无空格。

输入例子1：
4
1 2 3 4

输出例子1：
4 2 1 3

解法：每次都是先加右，再加左，然后逆序是规律的
*/

import java.util.Random;

public class Problem04 {

	public static void main(String[] args) {
		int[] arr = generateArray(9);
		System.out.println("Before reverse:");
		printArray(arr);
		reverse(arr);
		System.out.println("Before reverse:");
		printArray(arr);
	}

	public static void reverse(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		int mid = (n % 2 == 0) ? (n - 1) / 2 : (n - 1) / 2 - 1;
		for (int i = 0; i <= mid; i++) {
			int temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}
	}

	public static int[] generateArray(int size) {
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