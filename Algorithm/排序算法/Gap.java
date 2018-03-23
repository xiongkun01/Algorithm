public class Gap {
	
	//有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
	//给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
	public static int maxGap(int[] A, int n) {
		if (A == null || n == 0) {
			return 0;
		}

		int min = A[0];
		int max = A[0];
		for (int i = 1; i < n; i ++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		
		//若最大值和最小值相等，返回0
		if (min == max) {
			return 0;
		}

		boolean[] hasNum = new boolean[n + 1]; //桶是否为空桶
		int[] maxs = new int[n + 1]; //每个桶的最大值
		int[] mins = new int[n + 1]; //每个桶的最小值

		int bucketNum = 0; //桶号
		for (int i = 0; i < n; i ++) {
			//先获取该元素的桶号
			bucketNum = bucket(A[i], n, min, max);
			mins[bucketNum] = hasNum[bucketNum] ? Math.min(mins[bucketNum], A[i]) : A[i];
			maxs[bucketNum] = hasNum[bucketNum] ? Math.max(maxs[bucketNum], A[i]) : A[i];
			hasNum[bucketNum] = true; //该桶不空
		}

		int count = 0; //遍历到第几个桶
		int lastMax = 0;
		// 遍历n+1个桶  
		while (count <= n) {
			// 找到第一个非空桶  
			if (hasNum[count]) {
				lastMax = maxs[count];
				break;
			}
			count ++;
		} 

		int res = 0;
		// 待求的差值最大值一定出现在空桶附近的相邻2个桶之间  
		while (count <= n) {
			if (hasNum[count]) {
				res = Math.max(res, mins[count] - lastMax);
				lastMax = maxs[count];
			}
			count ++;
		}

		return res;

	}

	//计算第几号桶
	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}

	public static void main(String[] args) {
		int[] A = new int[] {1,2,5,4,6};
		int result = maxGap(A, A.length);

		System.out.println(result);
	}
}
