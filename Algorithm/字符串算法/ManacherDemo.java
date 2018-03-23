public class ManacherDemo {

	//求字符串的最长回文子串的长度，时间复杂度O(N)
	public int maxLcpsLength(String str) {
		if (str == null || str.length() <= 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < charArr.length; i++) {
			//index - i = index - i' => i' = 2 * index - 1; pR - 1 - i + 1 = pR - i;
			pArr[i] = pR > i ? Math.min(pArr[2 * index - 1], pR - i) : 1;
			//向两边扩
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			//更新index和pR
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			
		}
		//原字符串最长回文子串的长度为charArr的最大回文半径 - 1
		return max - 1;
	}

	public char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i < res.length; i++) {
			// i & 1 等价于 i % 2
			res[i] == (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}
}