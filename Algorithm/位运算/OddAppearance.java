import java.util.*;

/*
有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
要求时间复杂度为O(N)，额外空间复杂度为O(1)。

给定整形数组A及它的大小n，请返回题目所求数字。
*/
public class OddAppearance {
    public int findOdd(int[] A, int n) {
        // write code here
		if (A == null || n <= 0) {
			return Integer.MIN_VALUE;
		}

		int e = 0;
		for (int i = 0; i < n; i ++) {
			e = e ^ A[i];
		}
		return e;
    }
}