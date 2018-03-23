import java.util.*;

/*
数组小和的定义如下：
例如：数组s=[1, 3, 5, 2, 4, 6],在s[0]的左边小于或等于s[0]的
数的和为0，在s[1]的左边小于或等于s[1]的数的和为1，在s[2]的左边
小于或等于s[2]的数的和为1+3=4，在s[3]的左边小于或等于s[3]的数的和为1，
在s[4]的左边小于或等于s[4]的数的和为1+3+2=6，在s[5]的左边小于或等于s[5]
的数的和为1+3+5+2+4=15，所以s的小和为0+1+4+1+6+15=27.
给定一个数组s，实现函数返回s的小和。

求解：改写递归版本的归并排序
*/
public class Problem02 {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 5, 2, 4, 6};
		
		int smallSum = mergeSort(arr, 0, arr.length - 1);

		System.out.println("The small sum is : " + smallSum);
	}

	public static int mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			return 0;
		}
		
		int mid = (high + low) / 2;
		return mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high) 
										+ merge(arr, low, mid, high);
		
	}


	//合并过程
	public static int merge(int[] arr, int low, int mid, int high) {
		int[] tempArr = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		int smallSum = 0;

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				smallSum += (arr[i] * (high - j + 1));
				tempArr[k++] = arr[i++];
			} else {
				tempArr[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			tempArr[k++] = arr[i++];
		}

		while (j <= high) {
			tempArr[k++] = arr[j++];
		}

		k = 0;
		for (i = low; i <= high; i ++) {
			arr[i] = tempArr[k++];
		}

		return smallSum;
	}


}