import java.util.*;

/**
给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
*/
public class RandomPrint {
    public int[] print(int[] arr, int N, int M) {
        if (arr == null || N <= 0 || M <= 0) {
			return null;
        }

		Random ran = new Random();
		int[] res = new int[M];
		int p = 0;
		for (int i = 0; i < M; i ++) {
			p = ran.nextInt(N - i);
			res[i] = arr[p];
			swap(arr, p, N - i - 1);
		}
		return res;
    }

	public void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}