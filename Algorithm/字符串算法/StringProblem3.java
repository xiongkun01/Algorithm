import java.util.*;

/**
 给定一个数组，求该数组中最大的两个数。可以假设数组的长度大于2. O(N) and O(1).
*/
public class StringProblem3 {
	
	public static int[] topTwo(int[] nums) {
		int[] res = new int[2];
		res[0] = nums[0];
		res[1] = nums[0];
		int size = nums.length;
		for (int i = 1; i < size; i ++) {
			if (nums[i] > res[0]) {
				res[1] = res[0];
				res[0] = nums[i];
			} else if (nums[i] > res[1]) {
				res[1] = nums[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the number of array:");
		int n = scan.nextInt();
		
		System.out.println("Please input array:");
		int[] nums = new int[n];
		for (int i = 0; i < n; i ++) {
			nums[i] = scan.nextInt();
		}
		
		int[] res = topTwo(nums);
		System.out.println("The largest two number are " + res[0] + ", " + res[1]);
	}
}
