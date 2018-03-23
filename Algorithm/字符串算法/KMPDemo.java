public class KMPDemo {
	
	public int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] {-1};
		}

		int[] next = new int[ms.length];
		next[0] = - 1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
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

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
