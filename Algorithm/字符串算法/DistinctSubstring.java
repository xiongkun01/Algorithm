public class DistinctSubstring {


	public static void main(String[] args) {
		String A = "aabcb";
		int len = longestSubstring(A, A.length());

		System.out.println("the length of longestSubstring is :" + len);

	}

	public static int longestSubstring(String A, int n) {
		if (A == null || n <= 0) {
			return 0;
		}

		char[] arr = A.toCharArray();
		int[] map = new int[256]; //用来记录每个字符上次出现的位置
		for (int i = 0; i < n; i ++) {
			map[i] = -1;
		}

		int pre = -1; //用来记录以arr[i-1]结尾的最长无重复子串的开始下标
		int len = 0; //用来记录每次长度的最大值
		int cur = 0;
		for (int i = 0; i < n; i ++) {
			pre = Math.max(pre, map[arr[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[arr[i]] = i;
		}
		return len;
	}

}