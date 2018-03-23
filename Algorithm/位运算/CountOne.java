public class CountOne {

	public static void main(String[] args) {

	}

	//统计一个32位整数二进制表示中1的个数
	public static int count1(int num) {
		int res = 0;
		while (num != 0) {
			res += (num & 1);
			num = num >>> 1;
		}
		return res;
	}

}