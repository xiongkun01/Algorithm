import java.util.*;

public class  StringProblem2 {

	public static String deleteAllSpace(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		int i = 0, j = 0;
		char[] ch = str.toCharArray();
		while (j < ch.length && i < ch.length) {
			if (ch[j] != ' ') {
				if (i != j) {
					ch[i] = ch[j];
				}
				i ++;
			}
			j ++;
		}

		return new String(ch, 0, i);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please input a String with spaces:");
		String str = scan.nextLine();
		System.out.println("the String without spaces:" + deleteAllSpace(str));

	}
}
