import java.util.*;


/*
1、给定一个数组，值全是正数，请返回累加和为给定值k的最长子数组长度。

2、给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度。

3、给定一个数组，值可以为正、负和0，请返回累加和小于等于k的最长子数组长度。

总结：如果在面试或者笔试中看见最长子数组或子串长度，我可以通过以每个位置结尾或者每个
位置开始怎么样？然后观察i+1位置的值是否可以通过i位置（之前的位置）的值求出来。

*/
public class Problem02 {

	//2、给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度。
	public int maxLength2(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int len = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i ++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(i - map.get(sum - k), len);
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}

	// 3、给定一个数组，值可以为正、负和0，请返回累加和小于等于k的最长子数组长度。
	public int maxLength3(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		
	}

	public static void main(String[] args) {

	}

}