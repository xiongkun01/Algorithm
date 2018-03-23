import java.util.*;

/*
给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。
要求时间复杂度为O(N)，额外空间复杂度为O(1)。

给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
*/
public class OddAppearance2 {
    public int[] findOdds(int[] arr, int n) {
        // write code here
		if (arr == null || n <= 0) {
			return null;
		}

		int e0 = 0;
		for (int i = 0; i < n; i ++) {
			e0 ^= A[i];
		}
		int e1 = 0;
		int rightOne = e0 & (~e0 + 1);
		for (int cur : arr) {
			if ((cur & rightOne) != 0) {
				e1 ^= cur;
			}
		}	

		int small = Math.min(e1, (e0 ^ e1));
		int big = Math.max(e1, (e0 ^ e1));
		return new int[] {small, big};
    }
}