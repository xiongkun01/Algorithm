public class LongestConsecutive {

	//求数组中的最长连续序列的长度，时间复杂度为O(N)，空间复杂度为O(N)
	public int logestConsecutive(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if (map.containsKey(arr[i] - 1)) {
					max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
				}
				if (map.containsKey(arr[i] + 1)) {
					max = Math.max(max, merge(map, arr[i], arr[i] + 1));
				}
			}
		}
		return max;
	}


	public int merge(Map<Integer, Integer> map, int less, int more) {
		//求以less作为最大值的序列的开始值
		int left = less - map.get(less) + 1;
		//求以more作为最小值的序列的结束值
		int right = more + map.get(more) - 1;
		//求合并之后的长度
		int len = right - left + 1;
		map.put(left, len);
		map.put(right, len);
		return len;
	}

}