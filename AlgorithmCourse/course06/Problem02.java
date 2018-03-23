/*

如果一个数列s满足对于所有的合法的i，都有S[i+1] = S[i] + d，这里的d也可以是负数和零，
我们就称S为等差数列。小易现在有一个长度为n的数列x，小易想把x变为一个等差数列。
小易允许在数列上做交换任意两个位置的数值的操作，并且交换操作允许交换多次。但是有些
数列通过交换还是不能变成等差数列，小易需要判别一个数列是否能通过交换操作变成等差数列
输入描述：
输入包括两行，第一行包括整数n(2 <= n <= 50)，即数列的长度。
第二行n个元素x[i](0 <= x[i] <= 1000),
即数列中的每个整数。

Sn = n * a1 + n * (n - 1) * d / 2;
d = a2 - a1;
其中a1、a2为倒数最小的两个数
*/
import java.util.Scanner;

public class Problem02 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the number of array : ");
		int n = scan.nextInt();
		if (n < 2 || n > 50) {
			System.exit(-1);
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		if (isArithmeticSequence(arr, arr.length)) {
			System.out.println("Possible");
		} else {
			System.out.println("Inpossible");
		}
	}

	public static boolean isArithmeticSequence(int[] seq, int n) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			sum += seq[i];
			min = Math.min(min, seq[i]);
		}
		if ((2 * (sum - min)) % (n * (n - 1)) == 0) {
			return true;
		} else {
			return false;
		}
	}

}