/*
*****KMP字符串匹配********时间复杂度O(N)
1、nextArr[]的长度和match的长度一致，nextArr[i]表示match[0....i-1]的必须以match[0]开头的
前缀和必须以match[i-1]结尾的后缀的最长匹配的长度。
2、getNext()
2、
*/
public class KMPDemo2 {

	public static void main(String[] args) {
		String str = "abbsddd";
		String match = "bbsd";
		System.out.println(getIndexOf(str, match));
	}

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0; //s的指针
		int mi = 0; //m的指针
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				//让mi等于最长匹配的前缀字符串的后序一个位置
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < ms.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

}